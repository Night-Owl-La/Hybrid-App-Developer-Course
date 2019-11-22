<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>

<link rel="stylesheet" href="CSS/Main.css">
<link rel="stylesheet" href="CSS/Main_Menu.css">
<link rel="stylesheet" href="CSS/Sub_Menu.css">
</head>
<body>
	<div id="main_box">
		<div id="header">
			<%@ include file="./Header/Header.jsp"%>
		</div>
		<div id="aside">
			<%@ include file="./Menu/Sub_Menu_Company.jsp"%>
		</div>
		<div id="content">
			<c:if test="${ empty param.menu || param.menu == 'intro'}">
				<%@ include file="./Content/Company/Intro.jsp"%>
			</c:if>
			<c:if test="${ param.menu == 'history'}">
				<%@ include file="./Content/Company/History.jsp"%>
			</c:if>
			<c:if test="${ param.menu == 'location'}">
				<%@ include file="./Content/Company/Location.jsp"%>
			</c:if>
		</div>
		<div id="footer">
			<%@ include file="./Footer/Footer.jsp"%>
		</div>
	</div>

</body>
</html>
