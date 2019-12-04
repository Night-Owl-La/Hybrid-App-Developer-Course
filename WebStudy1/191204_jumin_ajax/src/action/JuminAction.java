package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jumin;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		jumin = request.getParameter("jumin");
//		System.out.println(jumin);
//		System.out.println(getUserGender());
//		System.out.println(getUserAge());
//		System.out.println(getUserYear());
//		System.out.println(getUserArea());
//		System.out.println(getUserTii());
//		System.out.println(getUserGanji());
//		System.out.println(getUserBirthSeason());

		int userGender = getUserGender();
		int userAge = getUserAge();
		int userYear = getUserYear();
		String userArea = getUserArea();
		String userTii = getUserTii();
		String userGanji = getUserGanji();
		String userBS = getUserBirthSeason();
		String userGender_String = ((userGender % 2) == 0 ? "여자" : "남자" );

		
		// 데이터 포장.
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		StringBuffer result_Sb = new StringBuffer();
		result_Sb.append("{");
		result_Sb.append(String.format("\"userGender_String\" : \"%s\",", userGender_String));
		result_Sb.append(String.format("\"userAge\" : \"%s\",", userAge));
		result_Sb.append(String.format("\"userYear\" : \"%s\",", userYear));
		result_Sb.append(String.format("\"userArea\" : \"%s\",", userArea));
		result_Sb.append(String.format("\"userTii\" : \"%s\",", userTii));
		result_Sb.append(String.format("\"userGanji\" : \"%s\",", userGanji));
		result_Sb.append(String.format("\"userBS\" : \"%s\"", userBS));
		result_Sb.append("}");

		out.print(result_Sb.toString());
	}

	public int getUserGender() {
		return Integer.parseInt(jumin.substring(7, 8));
	}

	public int getUserYear() {
		int u_Gender = getUserGender();
		int u_year = Integer.parseInt(jumin.substring(0, 2));

		if (u_Gender <= 2 || (u_Gender >= 5 && u_Gender <= 6))
			return (1900 + u_year);
		else
			return (2000 + u_year);
	}

	public int getUserAge() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR) - getUserYear();
	}

	public String getUserArea() {
		int u_AreaID = Integer.parseInt(jumin.substring(8, 10));
		String u_Area = null;

		if (u_AreaID <= 8)
			u_Area = "서울";
		else if (u_AreaID >= 9 && u_AreaID <= 12)
			u_Area = "부산";
		else if (u_AreaID >= 13 && u_AreaID <= 15)
			u_Area = "인천";
		else if (u_AreaID >= 16 && u_AreaID <= 25)
			u_Area = "경기도";
		else if (u_AreaID >= 26 && u_AreaID <= 34)
			u_Area = "강원도";
		else if (u_AreaID >= 35 && u_AreaID <= 39)
			u_Area = "충청북도";
		else if (u_AreaID >= 40 && u_AreaID <= 47) {
			u_Area = "충청남도";
			if (u_AreaID == 40)
				u_Area = u_Area + " 대전";
		} // 대전 40
		else if (u_AreaID >= 48 && u_AreaID <= 55)
			u_Area = "전라북도";
		else if (u_AreaID >= 56 && u_AreaID <= 66) {
			u_Area = "전라남도";
			if (u_AreaID >= 65 && u_AreaID <= 66)
				u_Area = u_Area + " 광주";
		} // 광주 65~66
		else if (u_AreaID >= 67 && u_AreaID <= 80) {
			u_Area = "경상북도";
			if (u_AreaID >= 67 && u_AreaID <= 69)
				u_Area = u_Area + " 대구";
		} // 대구 67~69
		else if (u_AreaID >= 81 && u_AreaID <= 99) {
			u_Area = "경상남도";
			if (u_AreaID == 85)
				u_Area = u_Area + " 울산";
		} // 울산 85

		return u_Area;
	}

	public String getUserBirthSeason() {
		int bSeason_Number = Integer.parseInt(jumin.substring(2, 4));
		String bSeason = null;

		if (bSeason_Number >= 3 && bSeason_Number <= 5)
			bSeason = "봄";
		else if (bSeason_Number >= 6 && bSeason_Number <= 8)
			bSeason = "여름";
		else if (bSeason_Number >= 9 && bSeason_Number <= 10)
			bSeason = "가을";
		else
			bSeason = "겨울";

		return bSeason;
	}

	public String getUserTii() {
		String[] tiiArray = { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };
		return tiiArray[getUserYear() % 12];
	}

	public String getUserGanji() {
		String[] GangiArray = { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };
		String Gangi = GangiArray[getUserYear() % 10] + getUserTii();
		return Gangi;
	}

}
