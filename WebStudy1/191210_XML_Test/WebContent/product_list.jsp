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
				<th>링크</th>
				<th>lprice</th>
				<th>hprice</th>
				<th>몰 이름</th>
				<th>상품 번호</th>
				<th>상품 타입</th>
			</tr>
			<c:forEach var="product" items="${ list }">
				<tr>
					<td><img src="${ product.image }" style="width:200px; height:200px;"/></td>
					<td>${ product.title }</td>
					<td><a href="${ product.link }">${ product.link }</a></td>
					<td><fmt:formatNumber value="${ product.lprice }" type="currency"></fmt:formatNumber></td>
					<td><fmt:formatNumber value="${ product.hprice }" type="currency"></fmt:formatNumber></td>
					<td>${ product.mallName }</td>
					<td>${ product.productId }</td>
					<td>${ product.productType }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>