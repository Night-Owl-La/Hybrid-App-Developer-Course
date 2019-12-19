<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/common.css" />
</head>
<body>
	<div id="main_box">
		<div id="head_box">
		<span><h3>${ book } is ${ book_desc }.</h3></span>
		<a href="list.do">목록보기</a>
		</div>
	</div>

</body>
</html>