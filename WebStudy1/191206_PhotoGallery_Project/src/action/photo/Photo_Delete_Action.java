package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;

@WebServlet("/photo/delete.do")
public class Photo_Delete_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext application = request.getServletContext();
		String web_Path = "/upload/";
		String saveDir = application.getRealPath(web_Path);
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		String filename = PhotoDao.getInstance().selectOne(p_idx).getP_filename();
		
		File f = new File(saveDir+filename);
		f.delete();
		
		PhotoDao.getInstance().delete(p_idx);
		response.sendRedirect("list.do");
		
	}
}
