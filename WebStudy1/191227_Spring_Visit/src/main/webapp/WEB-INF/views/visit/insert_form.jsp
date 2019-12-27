<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<style type="text/css">

*{
margin: 0px;
padding: 0px;
}

div{
width: 600px;
margin: auto;

}

th {
	text-align: center;
}

th td tr{
	padding: 5px;
}

h1{
text-align: center;
}

</style>


<script type="text/javascript">
	function send(form) {
		var name = form.name.value.trim();
		var content = form.content.value.trim();
		var pwd = form.pwd.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			form.name.value='';
			form.name.focus();
			return;
		}
		if (content == '') {
			alert('내용을 입력하세요');
			form.content.value='';
			form.content.focus();
			return;
		}
		if (pwd == '') {
			alert('비밀번호를 입력하세요');
			form.pwd.value='';
			form.pwd.focus();
			return;
		}

		form.submit();
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form class="" action="insert.do" method="post">
		<div>
			<table class="table table-bordered">
				<caption><h1>::: 방명록 글쓰기 :::</h1></caption>
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="name" value=""></td>
				</tr>
	
				<tr>
					<th>내용 :</th>
					<td><textarea name="content" rows="5" cols="60"></textarea></td>
				</tr>
	
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="pwd" value=""></td>
				</tr>
	
				<tr>
					<td colspan="2" align="center">
					<input type="button" name="" value="글쓰기" onclick="send(this.form);" class="btn btn-success">
					<input type="button" name="" value="목록보기"	onclick="location.href='list.do'" class="btn btn-info">
					</td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
