<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.night_owl.la.vo.PersonVo"%>
<%
	// non ioc 방식으로 객체 생성방법	// 
	
	//1. Constructor.
	//PersonVo p1 = new PersonVo("일길동", 30, "서울 마포 창천동");
	
	//2. Setter.
	//PersonVo p2 = new PersonVo();
	//p2.setName("이길동");
	//p2.setAge(20);
	//p2.setAddress("서울 마포 노고산동");
	
	//pageContext.setAttribute("p1", p1);
	//pageContext.setAttribute("p2", p2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr />
	<h2>p1's info</h2>
<hr />
 이름 : ${ p1.name } <br>
 나이 : ${ p1.age } <br>
 주소 : ${ p1.address }
<hr />
	<h2>p2's info</h2>
<hr />
 이름 : ${ p2.name } <br>
 나이 : ${ p2.age } <br>
 주소 : ${ p2.address }

</body>
</html>