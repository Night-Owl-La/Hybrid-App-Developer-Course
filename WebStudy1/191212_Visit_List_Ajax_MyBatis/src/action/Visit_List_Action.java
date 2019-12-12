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

import dao.VisitDao;
import vo.VisitVo;

@WebServlet("/visit/list.do")
public class Visit_List_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");

		Map<String, String> map = new HashMap<String, String>();

		if (search == null)
			search = "all";

		if (search.equals("all") == false) {

			switch (search) {
			case "name_content":
				map.put("name", search_text);
				map.put("content", search_text);
				break;

			case "name":
				map.put("name", search_text);
				break;

			case "content":
				map.put("content", search_text);
				break;

			default:
				break;
			}
		}

		List<VisitVo> list = VisitDao.getInstance().selectList(map);

		request.setAttribute("list", list);

		String forward = "/visit/list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
