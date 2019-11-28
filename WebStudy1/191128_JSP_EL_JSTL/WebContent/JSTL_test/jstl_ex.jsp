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
</head>
<body>

	<c:forEach begin="1" end="5" step="1" varStatus="i">
		<c:if test="${ i.index%2 != 0 }">
			<font color=red>${ i.index } : 안녕!<br></font>
		</c:if>
		<c:if test="${ i.index%2 == 0 }">
			<font color=blue>${ i.index } : 안녕!<br></font>
		</c:if>
	</c:forEach>

	<hr>

	<%
		String[] fruit_Array = { "apple", "banana", "orange" };
		pageContext.setAttribute("fruit_Array", fruit_Array);
	%>

	<ul>
		<c:forEach var="item" items="${pageScope.fruit_Array }">
			<li>${ item }</li>
		</c:forEach>
	</ul>

</body>
</html>