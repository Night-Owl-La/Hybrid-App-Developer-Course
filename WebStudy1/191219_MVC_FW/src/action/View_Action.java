package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View_Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String book = request.getParameter("book");

		String book_desc = null;

		switch (book) {
		case "java":
			book_desc = "OOP Style Language.";
			break;
		case "jsp":
			book_desc = "Web Application Development Language";
			break;
		case "oracle":
			book_desc = "DataBase Management System";
			break;
		case "android":
			book_desc = "Java Based Mobile Platform Operation System developed by Google";
			break;
		case "ios":
			book_desc = "C Based Mobile Platform Operation System developed by Apple";
			break;

		default:
			break;
		}
		
		request.setAttribute("book", book);
		request.setAttribute("book_desc", book_desc);
		
		return "view.jsp";
	}

}
