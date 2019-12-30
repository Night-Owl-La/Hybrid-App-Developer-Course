<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(form) {
		var title = form.title.value.trim();
		var photo1 = form.photo[0].value;
		var photo2 = form.photo[1].value;
		
		if(title==''){
			alert('제목을 입력하세요.');
			form.title.value='';
			form.title.focus='';
			return;
		}
		
		if(photo1==''){
			alert('첫번째 사진을 선택하세요.');
			return;
		}
		
		if(photo2==''){
			alert('두번째 사진을 선택하세요.');
			return;
		}
		
		form.submit();
	}
	
	function send2(form) {
		var title = form.title.value.trim();
		var photo1 = form.photo[0].value;
		var photo2 = form.photo[1].value;
		
		if(title==''){
			alert('제목을 입력하세요.');
			form.title.value='';
			form.title.focus='';
			return;
		}
		
		if(photo1==''){
			alert('첫번째 사진을 선택하세요.');
			return;
		}
		
		if(photo2==''){
			alert('두번째 사진을 선택하세요.');
			return;
		}
		form.action="multi_file_upload2.do"
		form.submit();
	}
</script>
</head>
<body>

	<form action="multi_file_upload.do" method="post" enctype="multipart/form-data">
		제목: <input name="title" /><br />
		사진1: <input type="file" name="photo" /><br />
		사진1: <input type="file" name="photo" /><br />
		<input type="button" value="복수 업로드" onclick="send(this.form);" />
		<input type="button" value="복수 업로드 [object]" onclick="send2(this.form);" />
	</form>

</body>
</html>