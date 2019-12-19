package action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert_Action extends HttpServlet {

	public String execute (HttpServletRequest request, HttpServletResponse response) {
		
		return "insert_form.jsp";
	}
}
