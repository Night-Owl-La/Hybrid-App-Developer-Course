<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style media="screen">
div {
	position: absolute;
	left: 50%;
	margin-left: -250px;
}

* {
	margin: 20px;
	padding: 0px;
}
</style>

<script type="text/javascript">
	var regular_socre = /^[0-9]{1,3}$/;
	function send(form) {
		var name = form.name.value.trim();
		var kor = form.kor.value.trim();
		var eng = form.eng.value.trim();
		var mat = form.mat.value.trim();

		if (name == '') {
			alert('이름을 입력하세요.');
			form.name.value = '';
			form.name.focus();
			return;
		}

		if (regular_socre.test(kor) == false || kor > 100) {
			alert('국어 성적을 정확하게 입력하세요.');
			form.kor.value = '';
			form.kor.focus();
			return;
		}

		if (regular_socre.test(eng) == false || eng > 100) {
			alert('영어 성적을 정확하게 입력하세요.');
			form.eng.value = '';
			form.eng.focus();
			return;
		}

		if (regular_socre.test(mat) == false || mat > 100) {
			alert('수학 성적을 정확하게 입력하세요.');
			form.mat.value = '';
			form.mat.focus();
			return;
		}

		if (confirm("정말 수정합니까?") == false) {
			return;
		}

		form.submit();
	}
</script>
</head>
<body>

	<div>
		<form class="" action="modify.do" method="post">

			<table class="table table-bordered table-hover" style="width: 300px;">
				<caption>
					<h1 style="text-align: center;">::: 성적 수정 :::</h1>
				</caption>
				<tr>
					<th>번호</th>
					<td><input type="number" name="idx" value="${ vo.getIdx() }"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${ vo.getName() }"></td>
				</tr>
				<tr>
					<th>국어</th>
					<td><input type="number" name="kor" value="${ vo.getKor() }"></td>
				</tr>
				<tr>
					<th>영어</th>
					<td><input type="number" name="eng" value="${ vo.getEng() }"></td>
				</tr>
				<tr>
					<th>수학</th>
					<td><input type="number" name="mat" value="${ vo.getMat() }"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" name=""
						value="수정" onclick="send(this.form);" class="btn btn-success"> <input
						type="button" name="" value="취소" onclick="location.href='list.do'" class="btn btn-default"></td>

				</tr>

			</table>
		</form>
	</div>

</body>
</html>
