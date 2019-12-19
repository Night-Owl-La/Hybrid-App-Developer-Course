package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class Visit_Insert_Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		VisitVo vo = new VisitVo();
		vo.setName(request.getParameter("name"));
		vo.setContent(request.getParameter("content").replaceAll("<br>", "\n"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setIp(request.getRemoteAddr());

		VisitDao.getInstance().insert(vo);

		return "/WEB-INF/views/visit/list.do";
	}

}
