<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="item" items="${ list }">
				<tr>
					<td>${ item.name }</td>
					<td>${ item.age }</td>
					<td>${ item.tel }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>