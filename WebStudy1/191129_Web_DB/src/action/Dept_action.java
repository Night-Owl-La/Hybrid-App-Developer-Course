package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVo;

@WebServlet("/dept_action.do")
public class Dept_action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<DeptVo> dept_ArrayList = DeptDAO.getInstance().selectList();
		
		req.setCharacterEncoding("utf-8");
		
		req.setAttribute("list", dept_ArrayList);
		
		String forward = "view_dept.jsp";
		RequestDispatcher disp = req.getRequestDispatcher(forward);
		disp.forward(req, resp);
	}
}
