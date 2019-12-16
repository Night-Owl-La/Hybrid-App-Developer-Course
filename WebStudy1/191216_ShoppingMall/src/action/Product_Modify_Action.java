package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

@WebServlet("/shop/product_modify.do")
public class Product_Modify_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ProductVo vo = new ProductVo();
		
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setCategory(request.getParameter("category"));
		vo.setP_num(request.getParameter("p_num"));
		vo.setP_name(request.getParameter("p_name"));
		vo.setP_company(request.getParameter("p_company"));
		vo.setP_price(Integer.parseInt(request.getParameter("p_price")));
		vo.setP_saleprice(Integer.parseInt(request.getParameter("p_saleprice")));
		vo.setP_content(request.getParameter("p_content"));
		
		ProductDao.getInstance().update(vo);
		
		response.sendRedirect("product_list.do");
	}
}
