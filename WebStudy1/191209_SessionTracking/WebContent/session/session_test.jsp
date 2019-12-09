<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = session.getId();
	long session_time = session.getCreationTime();
	Date date = new Date(session_time);
	
	session.setMaxInactiveInterval(60);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		세션 ID : <%= id %> <br>
		생성시간 : <%= date.toString() %>
	</div>

</body>
</html>