<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date"%>
<%
	int money = 120000000;
	pageContext.setAttribute("money", money);

	Date today = new Date();
	pageContext.setAttribute("today", today);

	String str_date = "2019-11-29 12:12:12.003";
	pageContext.setAttribute("str_date", str_date);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="${ money }" />
	<br>
	<fmt:formatDate value="${ today }" pattern="YYYY년MM월DD일 HH:mm:ss" />
	<br> ${ str_date }
	<br> ${ fn:substring(str_date,0,0+10) }
	<br> ${ fn:substring(str_date,10,10+str_date.length()) }
	<br>
	
</body>
</html>