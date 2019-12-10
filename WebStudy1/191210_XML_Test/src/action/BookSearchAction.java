package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Naver_Search_Util;
import vo.BookVo;

@WebServlet("/book_search.do")
public class BookSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String book_name = request.getParameter("book_name");
		if (book_name == null)
			book_name = "test";

		int start = Integer.parseInt(request.getParameter("start"));
		if(start==-1) start=1;
		
		int display = Integer.parseInt(request.getParameter("display"));
		if(display==-1) display=10;
		
		System.out.println("aaaaa");
		

		List<BookVo> list = null;
		try {
			list = Naver_Search_Util.search_Book(book_name, start, display);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("booksearchaction ok");
		
		request.setAttribute("list", list);

		String forward = "book_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward);
		disp.forward(request, response);
	}
}
