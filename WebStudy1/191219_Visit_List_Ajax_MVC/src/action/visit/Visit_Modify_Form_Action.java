package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class Visit_Modify_Form_Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("modify");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		
		request.setAttribute("vo", vo);

		return "/WEB-INF/views/visit/modify_form.jsp";
	}

}
