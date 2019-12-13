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
		<h1>Sawon List</h1>
	</div>
	<div id="content">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Sawon no</th>
				<th>Sawon name</th>
				<th>Sawon gender</th>
				<th>Dept no</th>
				<th>Sawon job</th>
				<th>Sawon hire</th>
				<th>Sawon manager</th>
				<th>Sawon pay</th>
				<th style="color: blue;">Sawon gogek</th>
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
					<td style="padding-left: 20px; color: blue;">
						<ul>
							<c:forEach var="gogek" items="${ sawon.gogek_list }">
								<li>${ gogek.gobun } : ${ gogek.goname }</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>