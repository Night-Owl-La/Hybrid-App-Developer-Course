package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/member/login.do")
public class Member_Login_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVo user = MemberDao.getInstance().selectOne(id);
		if(user==null) {
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		if(user.getPwd().equals(pwd)==false) {
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		// 세션 생성.
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//메인페이지로 이동
		response.sendRedirect("../photo/list.do");

	}

}
