package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class Visit_Modify_Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content").replace("\n", "<br>");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		int res = VisitDao.getInstance().update(vo);
		
		return "/WEB-INF/views/visit/list.do";
	}

}
