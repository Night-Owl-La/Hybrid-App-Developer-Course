package action.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

@WebServlet("/shop/cart_Insert.do")
public class Cart_Insert_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		int c_cnt = 1;
		
		CartVo vo = new CartVo(p_idx, m_idx, c_cnt);
		
		CartDao.getInstance().insert(vo);
		
//		request.setAttribute("ok", "ok");
		
		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{");
		jsonStr.append("\"ok\": \"ok\"");
		jsonStr.append("}");
		
		response.setContentType("html/plain; charset=utf-8");
		response.getWriter().print(jsonStr);
		
	}
}
