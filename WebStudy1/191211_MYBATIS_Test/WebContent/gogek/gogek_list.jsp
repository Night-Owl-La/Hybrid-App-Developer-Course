<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#header {
	text-align: center;
	
	margin: 20px;
}
</style>
</head>
<body>
	<div id="header">
		<h1>고객 목록</h1>
	</div>
	<div id="content">
		<table class="table table-bordered table-hover">
			<tr>
				<th>고객번호</th>
				<th>고객이름</th>
				<th>고객주소</th>
				<th>고객 주민등록번호</th>
				<th>고객담당자</th>
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
		</table>
	</div>

</body>
</html>