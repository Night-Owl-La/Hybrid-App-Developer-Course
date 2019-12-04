package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class Hello_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nation = request.getParameter("nation");

		String greet_message = "";

		switch (nation) {
		case "한국":
			greet_message = "[한국] : 안녕하세요";
			break;
		case "미국":
			greet_message = "[미국] : 안녕하세요";
			break;
		case "영국":
			greet_message = "[영국] : 안녕하세요";
			break;
		case "독일":
			greet_message = "[독일] : 안녕하세요";
			break;

		default:
			greet_message = "???";
			break;
		}

		System.out.println(greet_message);
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.print(greet_message);
	}
}
