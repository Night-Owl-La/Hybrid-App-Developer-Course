<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<String> cM7_Interval_Arraylist = new ArrayList<String>();
	cM7_Interval_Arraylist.add("C");
	cM7_Interval_Arraylist.add("E");
	cM7_Interval_Arraylist.add("G");
	cM7_Interval_Arraylist.add("B");

	pageContext.setAttribute("cM7_Interval_Arraylist", cM7_Interval_Arraylist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr />
	<h1>CM7</h1>
	<hr />
	<ul>
		<c:forEach var="interval" items="${ cM7_Interval_Arraylist }">
			<li>${ interval }</li>
		</c:forEach>
	</ul>

</body>
</html>