package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

@WebServlet("/sawon/sajob_list.do")
public class Sawon_SajobList_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String sajob = request.getParameter("sajob");
		
		List<SawonVo> list = null;

		if (sajob == null)// 전체조회
			list = SawonDao.getInstance().selectList();
		else // 직급별 조회
			list = SawonDao.getInstance().selectList(sajob);

		request.setAttribute("list", list);

		String forward = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
