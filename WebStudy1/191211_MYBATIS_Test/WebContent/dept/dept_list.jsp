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

html, body {
	width: 100%;
	height: 100%;
}

#header {
	text-align: center;
	margin: 20px;
}

#content {
	margin: 20px;
}

#bottom {
	margin: 20px;
	height: 100%;
}
</style>
</head>
<body>

	<div id="header" class="alert alert-info">
		<h1>Department List</h1>
	</div>

	<div id="content">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Department No</th>
				<th>Department NAME</th>
				<th>Location</th>
				<th style="color: blue">Sawon list</th>
				<th style="color: green">Customer</th>
			</tr>

			<c:forEach var="dept" items="${ list }">
				<tr>
					<td>${ dept.deptno }</td>
					<td>${ dept.dname }</td>
					<td>${ dept.loc }</td>
					
					<td style="padding-left: 20px; color: blue;">
						<ul>
							<c:forEach var="sawon" items="${ dept.sa_list }">
								<li>${ sawon.sabun }:${ sawon.saname }</li>
							</c:forEach>
						</ul>
					</td>
					
					<td style="padding-left: 20px; color: green;">
						<ul>
							<c:forEach var="sawon" items="${ dept.sa_list }">
									<c:forEach var="gogek" items="${ sawon.gogek_list}">
										<li>${ gogek.goname }</li>
									</c:forEach>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="bottom" class="alert alert-info"></div>

</body>
</html>