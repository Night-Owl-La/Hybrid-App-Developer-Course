package action.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

@WebServlet("/shop/cart_update.do")
public class Cart_Update_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		CartVo vo = new CartVo();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
		
		CartDao.getInstance().update(vo);
		
		response.sendRedirect("cart_list.do");
	}
}
