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

@WebServlet("/sawon/sapay_list.do")
public class Sawon_SapayList_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int min_pay = 0; 
		int max_pay = 0;
		
		List<SawonVo> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// is not Empty.
		if(request.getParameter("min_pay").isEmpty()==false) min_pay = Integer.parseInt(request.getParameter("min_pay"));
		if(request.getParameter("max_pay").isEmpty()==false) max_pay = Integer.parseInt(request.getParameter("max_pay"));
		
		// put to map.
		map.put("min_pay", min_pay);
		map.put("max_pay", max_pay);
		
		// handling.
		if (min_pay == 0 && max_pay == 0)// 전체조회
			list = SawonDao.getInstance().selectList();
		else { // 급여 범위내 조회
			list = SawonDao.getInstance().selectList(map);
		}

		// binding.
		request.setAttribute("list", list);

		String forward = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
