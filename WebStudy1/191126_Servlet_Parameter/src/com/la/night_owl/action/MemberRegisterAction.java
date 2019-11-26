package com.la.night_owl.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/memberinfo_inputform.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NAME = "name";
	private static final String ID = "id";
	private static final String PWD = "pwd";
	private static final String GENDER = "gender";
	private static final String HOBBY = "hobby";
	private static final String BLOODTYPE = "bloodtype";
	private static final String PROFILE = "profile";

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

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
		String name = request.getParameter(NAME);
		String id = request.getParameter(ID);
		String pwd = request.getParameter(PWD);
		String gender = request.getParameter(GENDER);
		String hobbies[] = request.getParameterValues(HOBBY);
		String bloodType = request.getParameter(BLOODTYPE);
		String profile = request.getParameter(PROFILE);

		// 비밀번호 필터링.
		StringBuffer pwd_Filter = new StringBuffer();
		pwd_Filter.append(pwd.substring(0, 0 + 2));
		for (int i = 2; i < pwd.length(); i++) {
			pwd_Filter.append("*");
		}

		// 취미 핸들링.
		StringBuffer hobbyList = new StringBuffer();
		if (hobbies == null) {
			hobbies[0] = "취미없음";
		}
		for (String hobby : hobbies) {
			hobbyList.append(hobby + " ");
		}

		// profile 개행문자 처리.
		profile = profile.replace("\n", "<br>");

		// 응답.
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		StringBuffer out_Buf = new StringBuffer();
		out_Buf.append("<body><table border=\"1\">");
		out_Buf.append(String.format("<tr><th>이름</th><td>%s</td></tr>", name));
		out_Buf.append(String.format("<tr><th>ID</th><td>%s</td></tr>", id));
		out_Buf.append(String.format("<tr><th>PW</th><td>%s</td></tr>", pwd_Filter.toString()));
		out_Buf.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		out_Buf.append(String.format("<tr><th>혈액형</th><td>%s</td></tr>", bloodType));
		out_Buf.append(String.format("<tr><th>취미</th><td>%s</td></tr>", hobbyList));
		out_Buf.append(String.format("<tr><th>자기소개</th><td>%s</td></tr>", profile));
		out_Buf.append("</table></body>");

		out.print(out_Buf.toString());
	}

}
