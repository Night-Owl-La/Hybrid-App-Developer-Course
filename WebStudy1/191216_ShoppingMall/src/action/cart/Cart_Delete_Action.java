package action.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;

@WebServlet("/shop/cart_delete.do")
public class Cart_Delete_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		
		CartDao.getInstance().delete(c_idx);
		
		response.sendRedirect("cart_list.do");
	}
}
