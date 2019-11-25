package com.la.night_owl.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc.do")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Monitoring.
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();

		StringBuffer monitor_Sb = new StringBuffer();
		monitor_Sb.append(" " + ip);
		monitor_Sb.append(" " + host);
		monitor_Sb.append(" " + user);
		monitor_Sb.append(" " + port);

		System.out.println(monitor_Sb.toString());

		// Logic.
		double su1;
		double su2;
		if(request.getParameter("su1")==null || request.getParameter("su1").isEmpty()) su1=0;
		else if(request.getParameter("su2")==null || request.getParameter("su2").isEmpty()) su2=0;
		
		su1 = (request.getParameter("su1")==null || request.getParameter("su1").isEmpty()) ? su1=0 : Double.parseDouble(request.getParameter("su1"));
		su2 = (request.getParameter("su2")==null || request.getParameter("su2").isEmpty()) ? su1=0 : Double.parseDouble(request.getParameter("su2"));

		double result_Add = su1 + su2;
		double result_Sub = su1 - su2;
		double result_Mul = su1 * su2;
		double result_Div = su1 / su2;
		double result_Mod = su1 % su2;

		String result_Add_ST = String.format("<h2>%.1f + %.1f = %.1f</h2>", su1, su2, result_Add);
		String result_Sub_ST = String.format("<h2>%.1f - %.1f = %.1f</h2>", su1, su2, result_Sub);
		String result_Mul_ST = String.format("<h2>%.1f * %.1f = %.1f</h2>", su1, su2, result_Mul);
		String result_Div_ST = String.format("<h2>%.1f / %.1f = %.1f</h2>", su1, su2, result_Div);
		String result_Mod_ST = String.format("<h2>%.1f %% %.1f = %.1f</h2>", su1, su2, result_Mod);

		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		StringBuffer out_Sb = new StringBuffer();

		out_Sb.append("<html><head><title></title><head><body>");
		out_Sb.append("<hr>");
		out_Sb.append("<h2>계산결과</h2>");
		out_Sb.append("<hr>");
		out_Sb.append(result_Add_ST);
		out_Sb.append(result_Sub_ST);
		out_Sb.append(result_Mul_ST);
		out_Sb.append(result_Div_ST);
		out_Sb.append(result_Mod_ST);
		out_Sb.append("<hr>");
		out_Sb.append("<a href='client.html'>다시하기</a>");

		out.print(out_Sb.toString());

	}

}
