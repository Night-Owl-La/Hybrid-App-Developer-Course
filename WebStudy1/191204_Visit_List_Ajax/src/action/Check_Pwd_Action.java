package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

@WebServlet("/visit/check_pwd.do")
public class Check_Pwd_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result = "diff";
		if(vo.getPwd().equals(c_pwd)) {
			result = "same";
		}
			String resultStr = String.format("{\"result\":\"%s\"}", result);
		
		response.setContentType("text/plain; charset=utf-8;");
		response.getWriter().print(resultStr);

	}
}
