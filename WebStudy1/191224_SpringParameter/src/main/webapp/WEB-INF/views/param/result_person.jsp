<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr />
	<h2>${ title }</h2>
<hr />
<ul>
	<li>이름: ${ vo.name }</li>
	<li>나이: ${ vo.age }</li>
	<li>전화: ${ vo.tel }</li>
	<li>
		<c:if test="${ empty vo.hobby }"> 취미 없음. </c:if>
		<c:forEach var="item" items="${ vo.hobby }">
			${ item } &nbsp;
		</c:forEach>
	</li>
</ul>

</body>
</html>