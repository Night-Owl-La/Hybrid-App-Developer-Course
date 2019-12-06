<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/member.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function send(form) {

		if (form.p_subject.value == '') {
			alert('제목을 입력하세요.');
			return;
		}
		if (form.p_content.value == '') {
			alert('내용을 입력하세요.');
			return;
		}

		if (form.file.value == '') {
			alert('업로드 할 파일을 선택하세요.');
			return;
		}

		alert('success');

		form.submit();
	}
</script>
</head>
<body>
	<div class="main_box">
		<form action="insert.do" enctype="multipart/form-data" method="post">
			<table  class="table table-bordered table-hover member_signup_box">
				<caption><h1>:::사진 업로드:::</h1></caption>
				
				<tr>
					<th>제목</th>
					<td><input name="p_subject" style="width: 100%;" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="p_content" row="5" cols"50" style="width: 100%; resize: none;"></textarea>
					</td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
						<input type='file' name="file" class="btn btn-success"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input id="btn_signup" type="button" value="확인" class="btn btn-success" onclick="send(this.form);"/>
						<input type="button" value="취소" class="btn btn-warning" onclick="location.href='${ pageContext.request.contextPath}/photo/list.do';"/>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
