package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

@WebServlet("/visit/insert.do")
public class Insert_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		VisitVo vo = new VisitVo();
		vo.setName(request.getParameter("name"));
		vo.setContent(request.getParameter("content").replaceAll("\n", "<br>"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setIp(request.getRemoteAddr());
		
		VisitDao.getInstance().insert(vo);
		
		response.sendRedirect("list.do");
	}
}
