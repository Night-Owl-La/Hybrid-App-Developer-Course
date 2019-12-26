<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<table class="table table-bodered table-hover">
		<tr>
			<th>dept no</th>
			<th>dept name</th>
			<th>dept loc</th>
		</tr>
		<c:forEach var="dept" items="${ list }">
			<tr>
				<td>${ dept.deptno }</td>
				<td>${ dept.dname }</td>
				<td>${ dept.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>