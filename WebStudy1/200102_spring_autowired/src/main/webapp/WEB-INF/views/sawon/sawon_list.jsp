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
</head>
<body>

	<table border="1">
		<tr>
			<th>sabun</th>
			<th>saname</th>
			<th>sasex</th>
			<th>deptno</th>
			<th>sajob</th>
			<th>sahire</th>
			<th>samgr</th>
			<th>sapay</th>
		</tr>

		<tr>
			<c:forEach var="sawon" items="${ list }">
				<tr>
					<td>${ sawon.sabun }</td>
					<td>${ sawon.saname }</td>
					<td>${ sawon.sasex }</td>
					<td>${ sawon.deptno }</td>
					<td>${ sawon.sajob }</td>
					<td>${ sawon.sahire }</td>
					<td>${ sawon.samgr }</td>
					<td><fmt:formatNumber type="currency" value="${ sawon.sapay }" /></td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>