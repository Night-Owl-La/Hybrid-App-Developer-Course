package com.la.night_owl.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String data_1 = "nation";

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Monitoring.
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();

		StringBuffer monitor_Sb = new StringBuffer();
		monitor_Sb.append(" :" + ip);
		monitor_Sb.append(" :" + host);
		monitor_Sb.append(" :" + user);
		monitor_Sb.append(" :" + port);
		System.out.println(String.format("request : %s", monitor_Sb));

		// Logic.
		String request_data_1 = request.getParameter(data_1);
		System.out.println(request_data_1);
		if (request_data_1 == null || request_data_1.isEmpty()) {
			request_data_1 = "kor";
		}

		String response_data = "";

		switch (request_data_1) {
		case "kor":
			response_data = "ㅎㅇ";
			break;
		case "eng":
			response_data = "Hi";
			break;
		case "chn":
			response_data = "니하오";
			break;
		case "jap":
			response_data = "오하요";
			break;
		case "ger":
			response_data = "구텐탁";
			break;

		default:
			response_data = "ㄴㄴ";
			break;
		}

		// ---------------
		// Response to Client

		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		StringBuffer out_Sb = new StringBuffer();
		String answer = String.format("<h1>[ip: %s] 안녕~!</h1>", ip);

		out_Sb.append("<html>");
		out_Sb.append("<header><title>localhost</title></head>");
		out_Sb.append("<body>");
		out_Sb.append(answer);
		out_Sb.append("<a href='greet.html'>다시하기</a>");
		out_Sb.append("</body>");
		out_Sb.append("</html>");
		out.print(out_Sb.toString());

		out.print("<h1>" + response_data + "</h1>");

	}

}