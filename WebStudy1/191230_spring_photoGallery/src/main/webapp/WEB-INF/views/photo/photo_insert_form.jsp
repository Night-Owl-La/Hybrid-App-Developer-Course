<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/member.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>
<script type="text/javascript">
	function send(form) {
		
		var p_content = CKEDITOR.instances.p_content.getData();

		if (form.p_subject.value == '') {
			alert('제목을 입력하세요.');
			return;
		}
		if (p_content == '') {
			alert('내용을 입력하세요.');
			return;
		}

		if (form.photo.value == '') {
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
						<script>
							// Replace the <textarea id="editor1"> with a CKEditor instance, using default configuration.
							CKEDITOR.replace('p_content', {
								filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorImageUpload.do',
								enterMode: CKEDITOR.ENTER_BR,
								shiftEnterMode: CKEDITOR.ENTER_P,
								toolbarGroups: [
									/*
										{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
										{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
										{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
										{ name: 'forms' },
										'/',*/
						
									{	name: 'document', groups: ['mode', 'document', 'doctools'] },
									{ name: 'basicstyles', groups: ['basicstyles', 'cleanup'] },
									{ name: 'paragraph', groups: ['list', 'indent', 'blocks', 'align', 'bidi'] },
									{ name: 'links' },
									{ name: 'insert' },
									'/',
									{ name: 'styles' },
									{ name: 'colors' },
									{ name: 'tools' },
									{ name: 'others' },
									{ name: 'about' }
								]
							});
						
							//이미지 업로드
							CKEDITOR.on('dialogDefinition', function (ev) {
								var dialogName = ev.data.name;
								var dialogDefinition = ev.data.definition;
						
								switch (dialogName) {
									case 'image': //Image Properties dialog
										//dialogDefinition.removeContents('info');
										dialogDefinition.removeContents('Link');
										dialogDefinition.removeContents('advanced');
										break;
								}
							});
						</script>
					</td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
						<input type='file' name="photo" class="btn btn-success"/>
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
