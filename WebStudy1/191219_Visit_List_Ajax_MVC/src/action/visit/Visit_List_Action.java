package action.visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class Visit_List_Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("check visit list action");
		
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
		
		return "/WEB-INF/views/visit/list.jsp";
	}
}
