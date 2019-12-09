<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("C", "c.jsp");

	cookie.setMaxAge(60*5);
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
	I'm C.jsp
	<br>
	<a href="a.jsp">A로 이동.</a>
</body>
</html>