<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!//상수 선언.
	private static final String NAME = "name";
	private static final String ID = "id";
	private static final String PWD = "pwd";
	private static final String GENDER = "gender";
	private static final String HOBBY = "hobby";
	private static final String BLOODTYPE = "bloodtype";
	private static final String PROFILE = "profile";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>

	<%
		// JAVA.
		request.setCharacterEncoding("utf-8");

		// Monitoring.
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();

		StringBuffer monitor_Sb = new StringBuffer();
		monitor_Sb.append(" :" + ip);
		monitor_Sb.append(" :" + host);
		monitor_Sb.append(" :" + user);
		monitor_Sb.append(" :" + port);
		System.out.println(String.format("request : %s", monitor_Sb));

		// Logic.
		String name = request.getParameter(NAME);
		String id = request.getParameter(ID);
		String pwd = request.getParameter(PWD);
		String gender = request.getParameter(GENDER);
		String hobbies[] = request.getParameterValues(HOBBY);
		String bloodType = request.getParameter(BLOODTYPE);
		String profile = request.getParameter(PROFILE);

		// 비밀번호 필터링.
		StringBuffer pwd_Filter = new StringBuffer();
		pwd_Filter.append(pwd.substring(0, 0 + 2));
		for (int i = 2; i < pwd.length(); i++) {
			pwd_Filter.append("*");
		}

		// 취미항목 핸들링.
		StringBuffer hobbyList = new StringBuffer();
		if (hobbies == null) {
			hobbies[0] = "취미없음";
		}
		for (String hobby : hobbies) {
			hobbyList.append(hobby + " ");
		}

		// profile 개행문자 처리.
		profile = profile.replace("\n", "<br>");
	%>

	<!-- View -->
	<table class="table table-bordered" style="width: 400px;">
		<tr>
			<th class="info">이름</th>
			<td><%=name%></td>
		</tr>
		<tr>
			<th class="info">ID</th>
			<td><%=id%></td>
		</tr>
		<tr>
			<th class="info">PW</th>
			<td><%=pwd_Filter%></td>
		</tr>
		<tr>
			<th class="info">성별</th>
			<td><%=gender%></td>
		</tr>
		<tr>
			<th class="info">혈액형</th>
			<td><%=bloodType%></td>
		</tr>
		<tr>
			<th class="info">취미</th>
			<td><%=hobbyList%></td>
		</tr>
		<tr>
			<th class="info">자기소개</th>
			<td><%=profile%></td>
		</tr>
	</table>
</body>
</html>