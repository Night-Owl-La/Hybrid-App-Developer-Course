package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Score_TB_DAO;
import vo.Score_Vo;

@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Score_Vo> scoreList = Score_TB_DAO.getInstance().selectList();

		for (Score_Vo score_Vo : scoreList) {
			System.out.println(score_Vo.toString());
		}
	}

}
