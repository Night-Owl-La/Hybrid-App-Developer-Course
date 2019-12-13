<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	var latitude, longitude;
	window.onload = function() {
		navigator.geolocation.getCurrentPosition(function(pos) {
			latitude = pos.coords.latitude;
			longitude = pos.coords.longitude;
			//alert("현재 위치는 : " + latitude + ", "+ longitude);
		});
	};

	function find() {
		var search = document.getElementById("search").value;
		if (search == '') {
			alert('검색어를 입력하세요');
			return;
		}

		location.href = "search.do?search=" + encodeURIComponent(search)
				+ "&latitude=" + latitude + "&longitude=" + longitude;

	}
</script>

</head>
<body>
	검색:
	<input id="search">
	<input type="button" value="검색" onclick="find();">
	<hr>

	<table border="1">
		<tr>
			<th width="20%">상호</th>
			<th width="15%">전화</th>
			<th width="30%">주소</th>
			<th width="10%">거리(m)</th>
			<th width="10%">위치(위도/경도)</th>
			<th width="20%">길찾기</th>
		</tr>
		<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.name }</td>
				<td>${ vo.telephone }</td>
				<td>${ vo.address }</td>
				<td>${ vo.distance }</td>
				<td>${ vo.latitude }<br>${ vo.longitude }</td>
				<td><input type="button" value="길찾기"
					onclick="location.href='http://map.daum.net/link/to/${vo.name},${vo.latitude },${ vo.longitude }'">

					<input type="button" value="지도보기"
					onclick="location.href='map_view.jsp?latitude=${vo.latitude}&longitude=${ vo.longitude }'">

				</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>