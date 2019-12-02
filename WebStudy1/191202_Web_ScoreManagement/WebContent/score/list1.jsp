<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style type="text/css">
div {
	position: absolute;
	left: 50%;
	margin-left: -250px;
}

* {
	margin: 20px;
	padding: 0;
	text-align: center;
}

th {
	text-align: center;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table class="table table-bordered table-hover"
			style="width: 600px; text-align: center;">
			<caption>
				<h1 style="text-align: center;">::: 학생 성적 :::</h1>
			</caption>

			<tr class="info">
				<th>순번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>순위</th>
				<th>비고</th>
			</tr>

			<c:if test="${ empty requestScope.scoreList }">
				<tr>
					<td colspan="9">데이터가 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach var="item" items="${ scoreList }">
				<tr>
					<td>${ item.idx }</td>
					<td>${ item.name }</td>
					<td>${ item.kor }</td>
					<td>${ item.eng }</td>
					<td>${ item.mat }</td>
					<td>${ item.tot }</td>
					<td>${ item.avg }</td>
					<td>${ item.rank }</td>
					<td><input type="button" value="수정"
						onclick="location.href='modify_form.do?idx=${item.idx}'" class="btn btn-info">
						<input type="button" value="삭제"
						onclick="location.href='delete_form.do?idx=${item.idx}'" class="btn btn-danger"></td>
				</tr>
			</c:forEach>

			<tr>
				<td><input type="button" value="성적등록"
					onclick="location.href='insert_form.do'" class="btn btn-primary"></td>
			</tr>

		</table>
	</div>
</body>
</html>
