package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

@WebServlet("/photo/insert.do")
public class Photo_Insert_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		String web_Path = "/upload/";
		String saveDir = application.getRealPath(web_Path);
		int maxSize = 1024 * 1024 * 100;
		
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String title = mr.getParameter(mr.getParameter("p_subject"));
		
		File photo_File = mr.getFile("file");
		
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		int m_idx = user.getIdx();
		String p_subject = mr.getParameter("p_subject");
		String p_content = mr.getParameter("p_content");
		String p_filename = photo_File.getName();
		String p_ip = request.getRemoteAddr();
		
		PhotoVo vo = new PhotoVo(m_idx, p_subject, p_content, p_filename, p_ip);
		PhotoDao.getInstance().insert(vo);
				
		response.sendRedirect("list.do");
	}
}
