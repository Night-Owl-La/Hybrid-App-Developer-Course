package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List_Action extends HttpServlet {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("jsp");
		list.add("oracle");
		list.add("android");
		list.add("ios");
		
		request.setAttribute("list", list);
		
		return "list.jsp";
		
	}

}
