<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	RequestDispatcher disp = request.getRequestDispatcher("B.jsp");
	disp.forward(request, response);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:forward page="B.jsp"></jsp:forward>

</body>
</html>