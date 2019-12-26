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
				<th>idx</th>
				<th>name</th>
				<th>kor</th>
				<th>eng</th>
				<th>mat</th>
			</tr>
			<c:forEach var="sung" items="${ list }">
				<tr>
					<td>${ sung.idx }</td>
					<td>${ sung.name }</td>
					<td>${ sung.kor  }</td>
					<td>${ sung.eng  }</td>
					<td>${ sung.mat }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>