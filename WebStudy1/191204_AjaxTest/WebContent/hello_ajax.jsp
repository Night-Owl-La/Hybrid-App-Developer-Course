<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript">
	function find() {
		var nation = document.getElementById("nation").value.trim();
		if (nation == '') {
			alert('국가명을 입력하세요');
			document.getElementById("nation").value = '';
			document.getElementById("nation").focus();
			return;
		}

		var url = "hello.do";
		var param = "nation=" + encodeURIComponent(nation, "utf-8");

		sendRequest(url, param, resultFn, "post");

	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			document.getElementById("disp").innerHTML = data;
		}
	}
</script>
</head>
<body>
	국가명:
	<input type="text" id="nation" />
	<input type="button" value="검색" onclick="find();" />

	<hr />
	<div id="disp"></div>

</body>
</html>