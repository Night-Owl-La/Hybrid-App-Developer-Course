<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style type="text/css">
div{
	width: 600px;
	margin: auto;
}
h1{
	text-align: center;
}
</style>
<script type="text/javascript">
	function send(form) {

		form.submit();
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form class="" action="modify.do" method="post">
		<div>
			<table border="1" class="table table-bordered" style="width: 600px;">
				<caption><h1>::: 글 수정 :::</h1></caption>
				
				<input type="hidden" name="idx" value="${ vo.getIdx() }" />
				
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="name" value="${ vo.getName() }"></td>
				</tr>
	
				<tr>
					<th>내용 :</th>
					<td><textarea name="content" rows="5" cols="60">${ vo.getContent() }</textarea></td>
				</tr>
	
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="pwd" value="${ vo.getPwd() }" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="button" name="" value="글수정" onclick="send(this.form);" class="btn btn-success">
					<input type="button" name="" value="돌아가기"	onclick="location.href='list.do'" class="btn btn-primary">
					</td>
				</tr>
	
			</table>
		</div>
	</form>

</body>
</html>
