<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String str_dan = request.getParameter("dan");
	int dan;

	if (str_dan == null || str_dan.isEmpty())
		dan = 2;
	else
		dan = Integer.parseInt(str_dan);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 500px">
		<caption><%=dan%>단보기
		</caption>

		<%
			for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<td><%=String.format("%d x %d = %d", dan, i, dan * i)%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>
