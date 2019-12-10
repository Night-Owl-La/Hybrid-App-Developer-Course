package action;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

@WebServlet("/list.do")

public class PersonXmlParserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		List<PersonVo> list = new ArrayList<PersonVo>();

		// get Document.
		SAXBuilder builder = new SAXBuilder();
		URL url = new URL("http://192.168.0.71:9090/191210_XML_Test/person.xml");
		Document doc = null;

		try {
			doc = builder.build(url);
		} catch (JDOMException e) {
			e.printStackTrace();
		}

		// packaging.
		Element root = doc.getRootElement();
		List<Element> p_list = root.getChildren("person");

		for (Element element : p_list) {
			String name = element.getChildText("name");
			String nickName = element.getChild("name").getAttributeValue("nickname");

			int age = 0;

			try {
				age = Integer.parseInt(element.getChildText("age"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			String tel = element.getChildText("tel");
			String hometel = element.getChild("tel").getAttributeValue("hometel");

			PersonVo vo = new PersonVo(name, age, tel);
			list.add(vo);
		}

		// binding.
		request.setAttribute("list", list);

		String forward = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
