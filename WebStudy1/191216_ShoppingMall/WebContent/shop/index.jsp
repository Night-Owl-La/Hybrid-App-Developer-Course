<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/product.css" />
<title></title>
<style>


a:link {
	text-decoration: none;
	color: navy
}

a:visited {
	text-decoration: none;
	color: navy
}

a:hover {
	text-decoration: none;
	color: red
}

#category_box a {
	font-size: 20px;
	font-weight: bold;
}

</style>
</head>
<body>

	<div id="main_box">
		<div id="headline" class="out_box alert alert-info">
			<h1>ITLAND SHOPPING CENTER</h1>
		</div>
			
		<div id="category_box" class="out_box alert alert-success">
			<a href="product_list.do?category=com001">컴퓨터</a> | 
			<a href="product_list.do?category=ele002">가전 제품</a> | 
			<a href="product_list.do?category=sp003">스포츠</a>
		</div>
		
		<div id="login_option_box" class="option_box alert alert-info">
		
			<c:if test="${ empty sessionScope.user }">
				<input type="button" value="login" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/member/login_form.do'" />
			</c:if>
			
			<c:if test="${ (not empty user) and (user.grade eq '관리자') }">
				<input type="button" value="상품등록" class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/shop/product_insert_form.do'" />
			</c:if>
			
			<c:if test="${ not empty user }">
				<input type="button" value="장바구니" class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/shop/cart_list.do'" />
				<input type="button" value="logout" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/member/logout.do'"/>
			</c:if>
			
		
		</div>
		
	</div>
</body>
</html>