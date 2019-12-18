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

@WebServlet("/shop/product_modify.do")
public class Product_Modify_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext application = request.getServletContext();

		String web_Path = "/images/";
		String saveDir = application.getRealPath(web_Path);
		int maxSize = 1024 * 1024 * 100;

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		
		ProductVo result_vo = new ProductVo();
		
		result_vo.setIdx(idx);
		result_vo.setCategory(mr.getParameter("category"));
		result_vo.setP_num(mr.getParameter("p_num"));
		result_vo.setP_name(mr.getParameter("p_name"));
		result_vo.setP_company(mr.getParameter("p_company"));
		result_vo.setP_price(Integer.parseInt(mr.getParameter("p_price")));
		result_vo.setP_saleprice(Integer.parseInt(mr.getParameter("p_saleprice")));
		result_vo.setP_content(mr.getParameter("p_content"));
		
		// image handling.
		
		//do
		
		//get old file name.
		String old_p_image_s = ProductDao.getInstance().selectOne(idx).getP_image_s();
		String old_p_image_l = ProductDao.getInstance().selectOne(idx).getP_image_l();

		// old file delete.
		File old_file_s = new File(saveDir+old_p_image_s);
		File old_file_l = new File(saveDir+old_p_image_l);
		old_file_s.delete();
		old_file_l.delete();
		
		//get new file.
		File p_image_s = mr.getFile("p_image_s");
		File p_image_l = mr.getFile("p_image_l");
		
		// new file update.
		result_vo.setP_image_s(p_image_s.getName());
		result_vo.setP_image_l(p_image_l.getName());
		
		ProductDao.getInstance().update(result_vo);
		
		response.sendRedirect("product_list.do");
	}
}
