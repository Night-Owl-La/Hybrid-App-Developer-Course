package action.photo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo/photo_one.do")
public class Photo_GetOne_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));

		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		request.setAttribute("photo_vo", vo);

		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{");
		jsonStr.append(String.format("\"p_filename\": \"%s\",", vo.getP_filename()));
		jsonStr.append(String.format("\"p_subject\": \"%s\",", vo.getP_subject()));
		jsonStr.append(String.format("\"p_content\": \"%s\"", vo.getP_content()));
		jsonStr.append("}");

		response.setContentType("html/plain; charset=utf-8");
		response.getWriter().print(jsonStr);
	}
}
