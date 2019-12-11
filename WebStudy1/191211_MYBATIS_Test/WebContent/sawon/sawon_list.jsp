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
		<h1>사원 목록</h1>
	</div>
	<div id="content">
		<table class="table table-bordered table-hover">
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>사원성별</th>
				<th>부서번호</th>
				<th>사원직급</th>
				<th>입사날짜</th>
				<th>사원담당자</th>
				<th>사원급여</th>
			</tr>

			<c:forEach var="sawon" items="${ list }">
				<tr>
					<td>${ sawon.sabun }</td>
					<td>${ sawon.saname }</td>
					<td>${ sawon.sasex }</td>
					<td>${ sawon.deptno }</td>
					<td>${ sawon.sajob }</td>
					<td>${ fn:substring(sawon.sahire,0,10) }</td>
					<td>${ sawon.samgr }</td>
					<td><fmt:formatNumber type="currency" value="${ sawon.sapay }" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>