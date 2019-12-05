package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

@WebServlet("/member/check_id.do")
public class Member_Check_ID_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		boolean result = false;
		
		if(vo==null) result = true;
		
		String jsonStr = String.format("{\"result\":%b}", result);
		
		response.setContentType("html/plain; charset=utf-8");
		response.getWriter().print(jsonStr);
		
	}
}
