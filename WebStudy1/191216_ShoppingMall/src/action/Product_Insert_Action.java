package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.ProductVo;

@WebServlet("/shop/product_insert.do")
public class Product_Insert_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ServletContext application = request.getServletContext();

		String web_Path = "/images/";
		String saveDir = application.getRealPath(web_Path);
		int maxSize = 1024 * 1024 * 100;

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		File s_file = mr.getFile("p_image_s");
		File l_file = mr.getFile("p_image_l");

		// Record setting.
		String category = mr.getParameter("category");
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_image_s = s_file.getName();
		String p_image_l = l_file.getName();
		String p_content = mr.getParameter("p_content");
		
		ProductVo vo = new ProductVo(category, p_num, p_name, p_company, p_price, p_saleprice, p_image_s, p_image_l, p_content);
		
		ProductDao.getInstance().insert(vo);

		response.sendRedirect("product_list.do?category=" + category);
	}
}
