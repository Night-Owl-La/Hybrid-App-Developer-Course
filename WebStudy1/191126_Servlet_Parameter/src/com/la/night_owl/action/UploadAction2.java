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
@WebServlet("/upload2.do")
public class UploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		String web_Path = "/upload/";
		String saveDir = application.getRealPath(web_Path);
		int maxSize = 1024 * 1024 * 100;

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String title = mr.getParameter("title");

		File photo_File_1 = null;
		File photo_File_2 = null;
		String fileName = null;

		try {
			photo_File_1 = mr.getFile("photo1");
			photo_File_2 = mr.getFile("photo2");
		} catch (Exception e) {
			fileName = "파일이 없습니다.";
			System.out.println(fileName);
			return;
		}

		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		out.printf("제목:%s<br>", title);
		out.printf("<img src='upload/%s' width='200'<br>", photo_File_1.getName());
		out.printf("<img src='upload/%s' width='200'<br>", photo_File_2.getName());
		out.printf("<a href='FileUpload_Form2.html'>다시하기</a>");

	}

}
