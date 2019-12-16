package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/shop/product_delete.do")
public class Product_Delete_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		
		ServletContext application = request.getServletContext();
		String web_Path = "/images/";
		String saveDir = application.getRealPath(web_Path);
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String p_image_s = ProductDao.getInstance().selectOne(idx).getP_image_s();
		String p_image_l = ProductDao.getInstance().selectOne(idx).getP_image_l();
		
		File f1 = new File(saveDir+p_image_s);
		File f2 = new File(saveDir+p_image_l);
		f1.delete();
		f2.delete();
		
		ProductDao.getInstance().delete(idx);
		response.sendRedirect("product_list.do");
	}
}
