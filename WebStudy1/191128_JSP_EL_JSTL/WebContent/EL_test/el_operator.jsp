<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hr>
	<h1>EL 연산자</h1>
	<hr>
	<h2>산술연산자: + - * / %</h2>
	<br> \${ 1+1 } -> ${ 1+1 }
	<br> \${ 1-1 } -> ${ 1-1 }
	<br> \${ 1*1 } -> ${ 1*1 }
	<br> \${ 1/1 } -> ${ 1/1 }
	<br> \${ 1%1 } -> ${ 1%1 }
	<br>
	<hr>
	<h2>관계연산자: > >= < <= == !=</h2>
	<hr>
	<br> \${ 2>1 } -> ${ 2 gt 1 }
	<br> \${ 2<1 } -< ${ 2 lt 1 }
	<br> \${ 2==1 } -> ${ 2 eq 1 }
	<br> \${ 2!=1 } -> ${ 2 != 1 }
	


</body>
</html>