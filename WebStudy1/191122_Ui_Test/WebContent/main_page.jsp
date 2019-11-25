<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="./css/main_page.css">
<link rel="stylesheet" href="./css/content.css" />
</head>
<body>
	<div id="canvas">
		<div id="header">
			<%@ include file="./header/header.jsp"%>
		</div>
		<div id="leftMenu">
			<%@ include file="./leftMenu/leftMenu.jsp"%>
		</div>
		<div id="body1">
			<c:if test="${ empty param.menu}"></c:if>

			<c:if test="${ param.menu == 'history'}">
				<%@ include file="./content/history/history.jsp"%>
			</c:if>
			<c:if test="${ param.menu == 'skill' }">
				<%@ include file="./content/skill/skill.jsp"%>
			</c:if>
			<c:if test="${ param.menu == 'project' }">
				<%@ include file="./content/project/project.jsp"%>
			</c:if>
			<c:if test="${ param.menu == 'hobby' }">
				<%@ include file="./content/hobby/hobby.jsp"%>
			</c:if>

		</div>
		<div id="footer"></div>

	</div>
</body>
</html>
