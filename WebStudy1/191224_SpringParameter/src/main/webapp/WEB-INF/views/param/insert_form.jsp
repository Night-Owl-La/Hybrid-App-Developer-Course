<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style>
.test_table {
	width: 25rem;
	margin: 5rem;
}

.test_table>caption {
	font-size: 3rem;
	text-align: center;
}
</style>

<script type="text/javascript">
	var regular_number = /^[0-9]+$/;

	function send(form) {
		var name = form.name.value.trim();
		var age = form.age.value.trim();
		var tel = form.tel.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			form.name.value = '';
			form.name.focus();
			return;
		}

		if (regular_number.test(age) == false) {
			alert('나이를 정확히 입력하세요');
			form.age.value = '';
			form.age.focus();
			return;
		}

		if (tel == '') {
			alert('전화번호를 입력하세요');
			form.tel.value = '';
			form.tel.focus();
			return;
		}
		
		form.submit();
	}
	
	function send1(form) {
		var name = form.name.value.trim();
		var age = form.age.value.trim();
		var tel = form.tel.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			form.name.value = '';
			form.name.focus();
			return;
		}

		if (regular_number.test(age) == false) {
			alert('나이를 정확히 입력하세요');
			form.age.value = '';
			form.age.focus();
			return;
		}

		if (tel == '') {
			alert('전화번호를 입력하세요');
			form.tel.value = '';
			form.tel.focus();
			return;
		}
		
		form.action='insert1.do';
		form.submit();
	}
	
	function send2(form) {
		var name = form.name.value.trim();
		var age = form.age.value.trim();
		var tel = form.tel.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			form.name.value = '';
			form.name.focus();
			return;
		}

		if (regular_number.test(age) == false) {
			alert('나이를 정확히 입력하세요');
			form.age.value = '';
			form.age.focus();
			return;
		}

		if (tel == '') {
			alert('전화번호를 입력하세요');
			form.tel.value = '';
			form.tel.focus();
			return;
		}
		
		form.action='insert2.do';
		form.submit();
	}
</script>
</head>

<body>

	<form action="insert.do">
		<table class="table table-bordered table-hover test_table">
			<caption>Test table</caption>
			<tr>
				<th>이름</th>
				<td><input name="name" value="hong"></td>
			</tr>

			<tr>
				<th>나이</th>
				<td><input name="age" value="20"></td>
			</tr>

			<tr>
				<th>전화</th>
				<td><input name="tel" value="010-0000-0000"></td>
			</tr>
			
			<tr>
				<th>취미</th>
				
				<td>
					<input type="checkbox" name="hobby" value="게임"/>게임
					<input type="checkbox" name="hobby" value="노래"/>노래
					<input type="checkbox" name="hobby" value="운동"/>운동
					<input type="checkbox" name="hobby" value="공부"/>공부
				</td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<input type="button" value="직접" onclick="send(this.form);">
					<input type="button" value="낱개" onclick="send1(this.form);">
					<input type="button" value="객체" onclick="send2(this.form);">
				</td>
			</tr>
		</table>
	</form>


</body>

</html>
