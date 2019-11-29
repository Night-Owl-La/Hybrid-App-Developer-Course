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

@WebServlet("/sawon.do")
public class Sawon_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SawonVo> sawon_ArrayList = SawonDao.getInstance().selectList();
		
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("sawon_ArrayList", sawon_ArrayList);
		
		String forward = "view_sawon.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
		
	}

}
