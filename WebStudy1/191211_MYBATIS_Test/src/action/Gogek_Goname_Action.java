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

@WebServlet("/gogek/goname_list.do")
public class Gogek_Goname_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String goname = request.getParameter("goname");
		
		List<GogekVo> list = null;

		if (goname == null && goname != "")// 전체조회
			list = GogekDao.getInstance().selectList();
		else // 직급별 조회
			list = GogekDao.getInstance().selectList(goname);

		request.setAttribute("list", list);

		String forward = "gogek_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
