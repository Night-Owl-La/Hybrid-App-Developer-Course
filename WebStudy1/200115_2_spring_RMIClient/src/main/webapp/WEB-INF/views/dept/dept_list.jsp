<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style type="text/css">

	#wrap{
		display: flex;
		justify-content: space-between;
	}
	#wrap .wrap_table{
	}
	
	#wrap .table_attr > td {
	font-weight: bold;
	}
	
	.table-hover{
		margin: 0 auto;
	}
</style>
</head>
<body>

<div id="wrap">
	<div class="wrap_table">
		<table class="table table-hover">
			<tr class="table_attr">
				<td>deptno</td>
				<td>dname</td>
				<td>loc</td>
			</tr>
			<c:forEach var="vo" items="${ list }">
				<tr>
				<td>${ vo.deptno }</td>
				<td>${ vo.dname }</td>
				<td>${ vo.loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="wrap_table">
		<table class="table table-hover">
			<tr class="table_attr">
				<td>deptno</td>
				<td>dname</td>
				<td>loc</td>
			</tr>
			<c:forEach var="vo" items="${ list }">
				<tr>
				<td>${ vo.deptno }</td>
				<td>${ vo.dname }</td>
				<td>${ vo.loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="wrap_table">
		<table class="table table-hover">
			<tr class="table_attr">
				<td>deptno</td>
				<td>dname</td>
				<td>loc</td>
			</tr>
			<c:forEach var="vo" items="${ list }">
				<tr>
				<td>${ vo.deptno }</td>
				<td>${ vo.dname }</td>
				<td>${ vo.loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</div>
</body>
</html>