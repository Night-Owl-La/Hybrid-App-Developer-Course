package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/member/insert.do")
public class Member_Insert_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String ip = request.getRemoteAddr();
		String grade = request.getParameter("grade");
		
		MemberDao.getInstance().insert(new MemberVo(name, id, pwd, zipcode, address, grade, ip));
		
		response.sendRedirect("list.do");
	}
}
