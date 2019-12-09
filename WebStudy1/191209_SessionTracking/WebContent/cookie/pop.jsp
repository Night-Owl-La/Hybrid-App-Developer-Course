<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Cookie[] cookies = request.getCookies();
	StringBuffer sb = new StringBuffer("[최근 방문 페이지]<br>");

	if (cookies != null) {

		for (Cookie cookie1 : cookies) {
			String name = cookie1.getName();

			if (name.equals("JSESSIONID") == false) {
				String value = cookie1.getValue();
				sb.append(String.format("<a href='%s'>%s</a><br>", value, name));
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#disp {
	width: 200px;
	height: 300px;
	background: gray;
	color: white;
	opacity: 0.5;
	position: absolute;
	top: 50px;
	right: 50px;
	border-radius: 10px;
	text-align: center;
	position: absolute
}

a{
	text-decoration: none;
	color: blue;
	font-size: 20px;
}
</style>

</head>
<body>

	<div>
		<div id="disp"><%= sb.toString() %></div>
	</div>

</body>
</html>