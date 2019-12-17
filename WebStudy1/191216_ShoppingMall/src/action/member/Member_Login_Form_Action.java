package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login_form.do")
public class Member_Login_Form_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 다른 페이지에서 미로그인 핸들링 됬을시.
		String reason = null;
		
		try {
			reason = request.getParameter("reason");
		} catch (NullPointerException e) {
			System.out.println("reason = null");
			reason = "";
		}
		
		
		String forward = "member_login_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
