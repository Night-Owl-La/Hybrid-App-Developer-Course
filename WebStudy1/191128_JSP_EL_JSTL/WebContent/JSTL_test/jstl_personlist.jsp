<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<PersonVo> p_List = new ArrayList<PersonVo>();
	p_List.add(new PersonVo("일길동", 31, "서울"));
	p_List.add(new PersonVo("이길동", 41, "대구"));
	p_List.add(new PersonVo("삼길동", 51, "부산"));
	p_List.add(new PersonVo("사길동", 21, "춘천"));
	p_List.add(new PersonVo("오길동", 61, "충남"));
	p_List.add(new PersonVo("육길동", 71, "대전"));

	pageContext.setAttribute("p_List", p_List);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<c:forEach var="item" items="${ p_List }" varStatus="status">
			<tr>
				<td>${ status.count }</td>
				<td>${ item.name }</td>
				<td>${ item.age }</td>
				<td>${ item.addr }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>