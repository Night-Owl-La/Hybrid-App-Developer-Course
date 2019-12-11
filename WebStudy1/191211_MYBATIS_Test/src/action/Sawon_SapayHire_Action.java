package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

@WebServlet("/sawon/sahire_list.do")
public class Sawon_SapayHire_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int start_year = 0; 
		int end_year = 0;
		
		List<SawonVo> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// is not Empty.
		if(request.getParameter("start_year").isEmpty()==false) start_year = Integer.parseInt(request.getParameter("start_year"));
		if(request.getParameter("end_year").isEmpty()==false) end_year = Integer.parseInt(request.getParameter("end_year"));
		
		// put to map.
		map.put("start_year", start_year);
		map.put("end_year", end_year);
		
		// handling.
		if (start_year == 0 && end_year == 0)// 전체조회
			list = SawonDao.getInstance().selectList();
		else { // 입사년도 범위내 조회
			list = SawonDao.getInstance().selectList_ByYear(map);
		}

		// binding.
		request.setAttribute("list", list);

		String forward = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
