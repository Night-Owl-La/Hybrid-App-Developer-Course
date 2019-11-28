<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id='personVo' class="vo.PersonVo"></jsp:useBean>
<jsp:setProperty name="personVo" property="name" param="name"/>
<jsp:setProperty name="personVo" property="age"/>
<jsp:setProperty name="personVo" property="addr"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름: <jsp:getProperty property="name" name="personVo"/><br>
나이: <jsp:getProperty property="age" name="personVo"/><br>
주소: <jsp:getProperty property="addr" name="personVo"/>

</body>
</html>