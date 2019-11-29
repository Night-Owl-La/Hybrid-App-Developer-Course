<%@page import="dao.SawonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("sawon_ArrayList", SawonDAO.getInstance().selectList());
	/* System.out.println(SawonDAO.getInstance().selectList()); */
%>
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
			<th>사원번호</th>
			<th>사원이름</th>
			<th>사원성별</th>
			<th>부서번호</th>
			<th>사원직급</th>
			<th>입사날짜</th>
			<th>사원상사</th>
			<th>사원연봉</th>
			
		</tr>
		<c:forEach var="item" items="${ sawon_ArrayList }">
			<tr>
				<td>${ item.sabun }</td>
				<td>${ item.saname }</td>
				<td>${ item.sasex }</td>
				<td>${ item.deptno }</td>
				<td>${ item.sajob }</td>
				<td>${ item.sahire }</td>
				<td>${ item.samgr }</td>
				<td>${ item.sapay }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>