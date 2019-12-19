<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<hr />
			<span><h3>리스트 내용</h3></span>
			<hr />
			<c:forEach var="book" items="${ list }">
				<li>
					<span>
						<a href="view.do?book=${ book }">${ book }</a>
					</span>
					<input type="button" value="삭제" onclick="location.href='delete.do?book=${ book }'"/>
				</li>
			</c:forEach>
			
			<a href="insert_form.do">입력폼</a>
		</div>
	</div>

</body>
</html>