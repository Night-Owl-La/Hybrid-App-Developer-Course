package action.visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

public class Visit_Check_Pwd_Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		if(vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
		
		String resultStr = String.format("{\"result\":\"%s\"}", result);
		
		request.setAttribute("resultStr", resultStr);
		
		return "/WEB-INF/views/visit/result_check_pwd.jsp";
		
	}

}
