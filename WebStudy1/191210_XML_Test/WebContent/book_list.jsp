<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>

	<div>
		<table class="table table-bordered table-hover">
			<tr>
				<th>이미지</th>
				<th>제목</th>
				<th>저자</th>
				<th>링크</th>
				<th>정가</th>
				<th>할인가</th>
				<th>출판사</th>
				<th>출판일자</th>
				<th>isbn</th>
			</tr>
			<c:forEach var="book" items="${ list }">
				<tr>
					<td><img src="${ book.image }" style="width:200px; height:200px;"/></td>
					<td>${ book.title }</td>
					<td>${ book.author }</td>
					<td><a href="${ book.link }">${ book.link }</a></td>
					<td><fmt:formatNumber value="${ book.price }" type="currency"></fmt:formatNumber></td>
					<td><fmt:formatNumber value="${ book.discount }" type="currency"></fmt:formatNumber></td>
					<td>${ book.publisher }</td>
					<td>${ book.pubdate }</td>
					<td>${ book.isbn }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>