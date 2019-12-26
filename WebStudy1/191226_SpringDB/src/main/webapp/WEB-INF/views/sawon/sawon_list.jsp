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
			<th>sawon number</th>
			<th>sawon name</th>
			<th>sawon gender</th>
			<th>sawon deptno</th>
			<th>sawon sajob</th>
			<th>sawon sahire</th>
			<th>sawon samgr</th>
			<th>sawon sapay</th>
		</tr>
		<c:forEach var="sawon" items="${ list }">
			<tr>
				<td>${ sawon.sabun }</td>
				<td>${ sawon.saname }</td>
				<td>${ sawon.sasex }</td>
				<td>${ sawon.deptno }</td>
				<td>${ sawon.sajob }</td>
				<td>${ sawon.sahire }</td>
				<td>${ sawon.samgr }</td>
				<td>${ sawon.sapay }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>