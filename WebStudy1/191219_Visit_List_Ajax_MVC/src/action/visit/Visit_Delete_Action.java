package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;

public class Visit_Delete_Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = VisitDao.getInstance().delete(idx);

		return "/WEB-INF/views/visit/list.do";
	}

}
