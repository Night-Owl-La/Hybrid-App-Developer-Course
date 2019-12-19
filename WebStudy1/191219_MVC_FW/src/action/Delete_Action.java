package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete_Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String book = request.getParameter("book");
		System.out.println(book + " delete !");
		
		return "redirect:list.do";
	}

}
