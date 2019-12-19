package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Visit_Insert_Form_Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "/WEB-INF/views/visit/insert_form.jsp";
	}

}
