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

@WebServlet("/gogek.do")
public class Gogek_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GogekVo> gogek_List = GogekDao.getInstance().selectList();

		request.setCharacterEncoding("utf-8");

		request.setAttribute("gogek_List", gogek_List);

		String forward = "view_gogek.jsp";
		RequestDispatcher disp = (RequestDispatcher) request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}

}
