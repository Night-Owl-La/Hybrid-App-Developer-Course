package com.la.night_owl.nation.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nation.do")
public class Nation_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String KOR_NAME = "한국";
	private static final String ENG_NAME = "미국";
	private static final String JAP_NAME = "일본";
	private static final String KOR_GREET_MESSAGE = "안녕";
	private static final String ENG_GREET_MESSAGE = "Hello";
	private static final String JAP_GREET_MESSAGE = "おはよう";

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nation = req.getParameter("nation");
		String nation_Name = "";
		String greet_Message = "";

		if (nation == null)
			nation = "jap";

		switch (nation) {
		case "kor":
			nation_Name = KOR_NAME;
			greet_Message = KOR_GREET_MESSAGE;
			break;

		case "eng":
			nation_Name = ENG_NAME;
			greet_Message = ENG_GREET_MESSAGE;
			break;

		case "jap":
			nation_Name = JAP_NAME;
			greet_Message = JAP_GREET_MESSAGE;
			break;

		default:
			break;
		}
		
		req.setAttribute("nation_Name", nation_Name);
		req.setAttribute("greet_Message", greet_Message);

		String forward = "nation_view.jsp";
		RequestDispatcher disp = req.getRequestDispatcher(forward);
		disp.forward(req, resp);
	}
}
