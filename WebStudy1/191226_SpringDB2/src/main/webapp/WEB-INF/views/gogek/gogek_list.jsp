<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<table class="table">
		<tbody>
			<tr>
				<th>gobun</th>
				<th>goname</th>
				<th>goaddr</th>
				<th>gojumin</th>
				<th>godam</th>
			</tr>
			<c:forEach var="gogek" items="${ list }">
				<tr>
					<td>${ gogek.gobun }</td>
					<td>${ gogek.goname }</td>
					<td>${ gogek.goaddr }</td>
					<td>${ gogek.gojumin }</td>
					<td>${ gogek.godam }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>