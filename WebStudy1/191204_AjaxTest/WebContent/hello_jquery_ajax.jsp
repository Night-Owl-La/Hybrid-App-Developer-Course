<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn_find").click(function() {
			var nation = $("#nation").val().trim();

			if (nation == '') {
				alert('국가명을 입력하세요');
				$("#nation").val('');
				$("#nation").focus();
				return;
			}

			$.ajax({
				url : 'hello.do',
				data : {
					'nation' : nation
				},
				success : function(res_data) {
					$("#disp").html(res_data);
				}
			}); // ajax end.
		}) //click end.
	}); // init end.
</script>
</head>
<body>
	국가명:
	<input type="text" id="nation" />
	<input type="button" value="검색" id="btn_find" />

	<hr />
	<div id="disp"></div>

</body>
</html>