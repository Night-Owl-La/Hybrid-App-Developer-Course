<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style type="text/css">
* {
	margin: 10px;
	padding: 0px;
}

th {
	width: 50px;
}

td {
	width: 100px;
}

hr {
	border: 0.5px dotted #84A93B;
}

.main_box {
	position: absolute;
	width: 500px;
	height: 500px;
	left: 50%;
	top: 10%;
	margin-left: -250px;
	padding: 20px;
	border: 1px double #84A93B;
	text-align: center;
}

.input_box {
	display: inline-block;
}

.table_box {
	display: inline-block;
}

.title_box {
	display: inline-block;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	var regular_Jumin = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$/;

	$(function() {
		$("#btn_result").click(function() {

			var jumin_no = $('#jumin_no').val();

			if (regular_Jumin.test(jumin_no) == false) {
				alert("주민등록번호를 제대로 입력하세요.");
				$('#jumin_no').val('');
				$('#jumin_no').focus();
				return;
			}

			$.ajax({
				url : 'jumin.do',
				data : {
					'jumin' : jumin_no
				},
				dataType : 'json',
				success : function(res_data) {
					$("#year").html(res_data.userYear);
					$("#age").html(res_data.userAge);
					$("#tii").html(res_data.userTii);
					$("#gender").html(res_data.userGender_String);
					$("#season").html(res_data.userBS);
					$("#area").html(res_data.userArea);
				}
			}); // ajax end;
		})
	})
</script>
</head>
<body>
	<div class="main_box">
		<div class="title_box">
			<h1>주민등록정보 확인</h1>
			<hr />
		</div>
		<div class="input_box">
			주민등록번호 : <input type="text" id="jumin_no"> <input
				type="button" value="결과" id="btn_result" class="btn btn-success">
		</div>
		<hr>
		<div class="table_box">
			<table class="table table-bordered" style="width: 250px;">
				<tr>
					<th>출생년도</th>
					<td><span id="year"></span></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><span id="age"></span></td>
				</tr>
				<tr>
					<th>띠</th>
					<td><span id="tii"></span></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><span id="gender"></span></td>
				</tr>
				<tr>
					<th>출생계절</th>
					<td><span id="season"></span></td>
				</tr>
				<tr>
					<th>출생지역</th>
					<td><span id="area"></span></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>
