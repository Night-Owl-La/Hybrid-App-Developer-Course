<%@page import="java.util.Properties"%>
<%@page import="test_util.MyProperty"%>
<%@page import="java.util.Map"%>
<%@page import="test_util.MyMap"%>
<%@page import="java.util.List"%>
<%@page import="test_util.MyList"%>
<%@page import="test_util.MySet"%>
<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	MySet mySet_Bean = (MySet) wc.getBean("mySet_Bean");
	Set set = mySet_Bean.getSet();
	pageContext.setAttribute("set", set);
	
	MyList myList_Bean = (MyList) wc.getBean("myList_Bean");
	List list = myList_Bean.getList();
	pageContext.setAttribute("list", list);
	
	MyMap myMap_Bean = (MyMap) wc.getBean("myMap_Bean");
	Map map = myMap_Bean.getMap();
	Set map_KeySet = map.keySet();
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("map_KeySet", map_KeySet);
	
	MyProperty myProp_Bean = (MyProperty) wc.getBean("myProp_Bean");
	Properties prop = myProp_Bean.getProp();
	Set prop_KeySet = prop.keySet();
	pageContext.setAttribute("prop", prop);
	pageContext.setAttribute("prop_KeySet", prop_KeySet);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main_box">
		<div id="sub_main_box">
			<div class="content_box">
				<h2>Set</h2>
				<ul>
					<c:forEach var="item" items="${ set }">
						<li>${ item }</li>
					</c:forEach>
				</ul>
			</div>
			
			<hr />
	
			<div class="content_box">
				<h2>List</h2>
				<ul>
					<c:forEach var="item" items="${ list }">
						<li>${ item }</li>
					</c:forEach>
				</ul>
			</div>
			
			<hr />
			
			<div class="content_box">
				<h2>Map</h2>
				<ul>
					
					<c:forEach var="item" items="${ map_KeySet }">
						<li>${ item } : ${ map[item] }</li>
					</c:forEach>
				</ul>
				
			</div>
			
			<hr />
			
			<div class="content_box">
				<h2>Property</h2>
				<ul>
					
					<c:forEach var="item" items="${ prop_KeySet }">
						<li>${item} : ${ prop[item] }</li>
					</c:forEach>
				</ul>
			</div>
			
		</div>
	</div>
</body>
</html>