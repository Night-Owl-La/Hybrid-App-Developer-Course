<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("A", "a.jsp");

	response.addCookie(cookie);
%>

<%@ include file="pop.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	I'm A.jsp
	<br>
	<a href="b.jsp">B로 이동.</a>

</body>
</html>