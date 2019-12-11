package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDao;
import vo.GogekVo;

@WebServlet("/gogek/list.do")
public class GogekList_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int gobun = 0;
		String str_gobun = request.getParameter("gobun");

		List<GogekVo> list = null;

		if (str_gobun != null && str_gobun != "") // 값이 들어올 경우.
			gobun = Integer.parseInt(str_gobun);

		if (gobun == 0) // 전체조회
			list = GogekDao.getInstance().selectList();
		else
			list = GogekDao.getInstance().selectList(gobun);

		request.setAttribute("list", list);

		String forward = "gogek_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
