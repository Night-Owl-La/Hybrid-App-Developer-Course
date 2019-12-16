package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/member/modify.do")
public class Member_Modify_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		
		MemberVo vo = MemberDao.getInstance().selectOne(idx);
		
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setZipcode(zipcode);
		vo.setAddress(address);
		vo.setGrade(grade);
		
		MemberDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");
	}
}
