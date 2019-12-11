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

@WebServlet("/sawon/list.do")
public class SawonList_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int deptno = 0;
		String str_deptno = request.getParameter("deptno");
		
		List<SawonVo> list = null;
		
		if (str_deptno != null) //값이 들어왔을 경우
			deptno = Integer.parseInt(str_deptno);

		if (deptno == 0)// 전체조회
			list = SawonDao.getInstance().selectList();
		else // 부서번호로 조회
			list = SawonDao.getInstance().selectList(deptno);

		request.setAttribute("list", list);

		String forward = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
