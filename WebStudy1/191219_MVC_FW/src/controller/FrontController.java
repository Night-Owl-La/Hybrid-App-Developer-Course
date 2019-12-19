package controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> action_Map = new HashMap<String, String>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String location = config.getInitParameter("location");
		String filename = config.getInitParameter("filename");
		
		//XML Parsser.
		SAXBuilder sb = new SAXBuilder();
		
		//get Full Path.
		String path = config.getServletContext().getRealPath(location);
		File f = new File(path, filename);
		
		try {
			Document doc = sb.build(f);
			Element root = doc.getRootElement();
			
			List<Element> list = root.getChildren("action");
			
			for (Element element : list) {
				String name = element.getAttributeValue("name");
				String class_Name= element.getAttributeValue("class");
				
				action_Map.put(name, class_Name);
								
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		int index = uri.lastIndexOf('/');
		
		String temp_uri = uri.substring(0,index);
		index = temp_uri.lastIndexOf("/");
		
		String cmd = uri.substring(index).replace(".do", "");
		String result_Page ="";
		
		String class_Name = action_Map.get(cmd);
		if(class_Name==null || class_Name.isEmpty()) return;
				
		try {
			Class c = Class.forName(class_Name);
			Object ob = c.newInstance();
			Method method = c.getDeclaredMethod("execute",HttpServletRequest.class, HttpServletResponse.class);
			result_Page = (String) method.invoke(ob, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result_Page.isEmpty()) return;
		
		if(result_Page.contains("redirect:")){
			result_Page = result_Page.replace("redirect:", "");
			response.sendRedirect(result_Page);
		}else
			request.getRequestDispatcher(result_Page).forward(request, response);
		

	}
}
