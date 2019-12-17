package action.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import vo.CartVo;
import vo.MemberVo;

@WebServlet("/shop/cart_list.do")
public class Cart_List_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// get user from session. 
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user == null) {
			response.sendRedirect("../member/login_form.do?reason=fail_cart_not_login");
			return;
		}
		
		List<CartVo> list = CartDao.getInstance().selectList(user.getIdx());
		int amount = CartDao.getInstance().selectAmount_Total(user.getIdx());
		
		request.setAttribute("list", list);
		request.setAttribute("amount", amount);
		
		String forward = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
