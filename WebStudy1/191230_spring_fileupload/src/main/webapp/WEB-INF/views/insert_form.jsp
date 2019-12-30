<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send1(form) {
		var title = form.title.value.trim();
		var photo = form.photo.value;
		
		if(title==''){
			alert('제목을 입력하세요.');
			form.title.value='';
			form.title.focus='';
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요.');
			return;
		}
		
		form.submit();
	}
	
	function send2(form) {
		var title = form.title.value.trim();
		var photo = form.photo.value;
		
		if(title==''){
			alert('제목을 입력하세요.');
			form.title.value='';
			form.title.focus='';
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요.');
			return;
		}
		form.action="file_upload2.do";
		form.submit();
	}
</script>
</head>
<body>

	<form action="file_upload1.do" method="post" enctype="multipart/form-data">
		제목: <input name="title" /><br />
		사진: <input type="file" name="photo" /><br />
		<input type="button" value="업로드1" onclick="send1(this.form);" />
		<input type="button" value="업로드2" onclick="send2(this.form);" />
	</form>

</body>
</html>