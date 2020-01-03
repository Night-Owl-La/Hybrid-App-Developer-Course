<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script type="text/javascript">
	$(function() {
		$("#userinfo").click(function() {
			$.ajax({
				url : 'test_userinfo.do',
				data : { 'a' : 'a'},
				dataType : 'json',
				success : function(res_data) {
					$('#last_name').html(res_data.name.last_name);
					$('#first_name').html(res_data.name.first_name);
					$('#age').html(res_data.age);
					$('#home_tel').html(res_data.tel.home);
					$('#phone_tel').html(res_data.tel.phone);
					$('#hobby').html(res_data.hobby);
					
				},
				error : function(error) {
					alert(error);
				}
			});
		});
	});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>
	<input type="button" value="map" onclick="location.href='test_map.do'" />
	<input type="button" value="person" onclick="location.href='test_person.do'" />
	<input type="button" value="list1" onclick="location.href='test_arraylist.do'" />
	<input type="button" value="list2" onclick="location.href='test_arraylist2.do'" />
	<input type="button" value="userinfo" id="userinfo"/><!-- onclick="location.href='test_userinfo.do'"  -->
</div>

<div>
	<table class="table table-bordered table-hover">
		<tr>
			<th>last name</th>
			<th>first name</th>
			<th>age</th>
			<th>home tel</th>
			<th>phone tel</th>
			<th>hobby</th>
		</tr>
		<tr>
			<td id="last_name"></td>
			<td id="first_name"></td>
			<td id="age"></td>
			<td id="home_tel"></td>
			<td id="phone_tel"></td>
			<td id="hobby"></td>
		</tr>
	</table>

</div>
</body>
</html>
