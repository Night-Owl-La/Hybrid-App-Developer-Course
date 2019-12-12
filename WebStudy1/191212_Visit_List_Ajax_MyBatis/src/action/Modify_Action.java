package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

@WebServlet("/visit/modify.do")
public class Modify_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content").replace("\n", "<br>");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		int res = VisitDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");
	}
}
