<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th, td {
	font-size: 40px;
	text-align: center;
}

th {
	font-weight: bold;
}
</style>
</head>
<body>
	<table border="1">
		<caption>
			<h1>::: 부서정보 :::</h1>
		</caption>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
		</tr>
		<c:forEach var="item" items="${ requestScope.list }">
			<tr>
				<td>${ item.deptno }</td>
				<td>${ item.dname }</td>
				<td>${ item.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>