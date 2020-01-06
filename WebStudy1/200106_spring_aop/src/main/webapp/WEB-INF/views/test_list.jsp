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
	<hr />
	Alphabet List
	<hr />
	<ul>
		<c:forEach var="alphabet" items="${ map.alphabet_List }">
			<li>${ alphabet }</li>
		</c:forEach>
	</ul>
	
	<hr />
	Number List
	<hr />
	<ul>
		<c:forEach var="number" items="${ map.number_List }">
			<li>${ number }</li>
		</c:forEach>
	</ul>

</body>
</html>