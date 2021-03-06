package com.la.night_owl.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadAction
 */
@WebServlet("/upload.do")
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		String web_Path= "/upload/";
		String saveDir = application.getRealPath(web_Path);
		int maxSize = 1024 * 1024 * 100;

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String title = mr.getParameter("title");
//		System.out.println(title);

		File file;
		String fileName;
		String original_FileName = mr.getOriginalFileName("photo");

		try {
			file = mr.getFile("photo");
			fileName = file.getName();
		} catch (Exception e) {
			fileName = "파일이 없습니다.";
		}
		
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		out.printf("제목:%s<br>", title);
		out.printf("<img src='upload/%s' width='200'<br>", fileName);
		out.printf("<a href='FileUpload_Form.html'>다시하기</a>");
		

//		System.out.println(fileName);
		
	}

}
