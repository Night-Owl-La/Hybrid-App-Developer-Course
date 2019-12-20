<%@page import="com.night_owl.la.vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);
	PersonVo p1 = (PersonVo) wc.getBean("p1");
	PersonVo p2 = (PersonVo) wc.getBean("p2");
	PersonVo p3 = (PersonVo) wc.getBean("p3");
	PersonVo p4 = (PersonVo) wc.getBean("p4");
	PersonVo galaxy_1 = wc.getBean("galaxy_1", PersonVo.class);
	
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);
	request.setAttribute("p3", p3);
	request.setAttribute("p4", p4);
	request.setAttribute("galaxy_1", galaxy_1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="content_box">
		<hr />
		<h2>p1's information.</h2>
		<hr />
		<h4>
			name : ${ p1.name } <br>
			age : ${ p1.age } <br>
			address : ${ p1.address }
		</h4>
		
		<hr />
		<h2>p2's information.</h2>
		<hr />
		<h4>
			name : ${ p2.name } <br>
			age : ${ p2.age } <br>
			address : ${ p2.address }
		</h4>
		
		<hr />
		<h2>p3's information.</h2>
		<hr />
		<h4>
			name : ${ p3.name } <br>
			age : ${ p3.age } <br>
			address : ${ p3.address }
		</h4>
		
		<hr />
		<h2>p4's information.</h2>
		<hr />
		<h4>
			name : ${ p4.name } <br>
			age : ${ p4.age } <br>
			address : ${ p4.address }
		</h4>
		
		<hr />
		<h2>galaxy_1's information.</h2>
		<hr />
		<h4>
			name : ${ galaxy_1.name } <br>
			age : ${ galaxy_1.age } <br>
			address : ${ galaxy_1.address }
		</h4>
	
	</div>

</body>
</html>