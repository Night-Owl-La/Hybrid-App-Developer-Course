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
	<table border="1">

		<tr>
			<th>고객번호</th>
			<th>고객이름</th>
			<th>고객주소</th>
			<th>고객주민등록번호</th>
			<th>고객담당자</th>
		</tr>

		<c:forEach var="item" items="${ gogek_List }">
			<tr>
				<td>${ item.gobun }</td>
				<td>${ item.goname }</td>
				<td>${ item.goaddr }</td>
				<td>${ item.gojumin }</td>
				<td>${ item.godam }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>