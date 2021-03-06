package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

@WebServlet("/visit/modify_form.do")
public class Modify_Form_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		
		System.out.println(content);
		
		request.setAttribute("vo", vo);
		
		String forward = "modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
