<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = "ASD";
	pageContext.setAttribute("page_value", "PageScope에 저장된 값");
	request.setAttribute("request_value", "requestScope에 저장된 값");
	session.setAttribute("session_value", "sessionScope에 저장된 값");
	application.setAttribute("application_value", "applicationScope에 저장된 값");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${pageScope.page_value}
	<br> ${requestScope.request_value }
	<br> ${sessionScope.session_value }
	<br> ${applicationScope.application_value } 
	<br> parameter : ${ param.value }

</body>
</html>