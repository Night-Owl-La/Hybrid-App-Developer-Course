<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PersonVo"%>
<%@ page import="java.util.*"%>
<%
	PersonVo p = new PersonVo();
	p.setName("hong");
	p.setAge(11);
	p.setAddr("aa dd ff");

	Map map = new HashMap();
	map.put("driver", "oracle.jdbc.driver.OracleDriver");
	map.put("url", "jdbc:oracle:thin:@localhost:1521:xe");
	map.put("user", "scott");
	map.put("pwd", "tiger");

	pageContext.setAttribute("p", p);
	pageContext.setAttribute("map", map);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ pageScope.p.name }
	<br> ${ p.age }
	<br> ${ p['addr'] }
	<hr>

	<h1>Map Data</h1>
	${ map.get("driver") }
	<br> ${ map.get("url") }
	<br> ${ map.user) }
	<br> ${ map.["pwd"] }
</body>
</html>