<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>쓰기</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css" type="text/css">
<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>
<script type="text/javascript">

	var p_content = CKEDITOR.instances.p_content.getData();

	function send(f) {

		if (f.board_title.value == '') {
			alert('제목을 입력하세요');
			f.board_title.focus();
			return;
		}

		if (p_content.value == '') {
			alert('내용을 입력하세요');
			f.board_content.focus();
			return;
		}

		f.submit();
	}
</script>

</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="760" align="center">
		<tr>
			<td>
				<table width="690" height="50" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><img src="${ pageContext.request.contextPath }/resources/img/title_04.gif"></td>
					</tr>
				</table> <!--타이틀 영역의 끝-->
			</td>
		</tr>
		<tr>
			<td>
				<form method="post" action="insert.do">
					<input type="hidden" name="user_idx" value="${ user.idx }"/>
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120" height="25" class="td_d">제목</td>
							<td class="td_d_1" colspan="3">
								<input name="board_title" type="text" class="search" style="width: 99.5%;">
							</td>

						</tr>
						<tr>
							<td height="25" class="td_d_4">작성자</td>
							<td class="td_d_2" colspan="3">
								<input name="user_name" type="text" value="${ user.name }" readonly="readonly" class="search" style="width: 99.5%;">
							</td>
						</tr>

						<tr>
							<td class="td_d_4">내용</td>
							<td class="td_d_2" colspan="3">
								<TEXTAREA id="content" name='board_content' rows="9" style="width: 99%"></TEXTAREA>
								<script>
									// Replace the <textarea id="editor1"> with a CKEditor instance, using default configuration.
									CKEDITOR
											.replace(
													'content',
													{
														filebrowserUploadUrl : '${pageContext.request.contextPath}/ckeditorImageUpload.do',
														enterMode : CKEDITOR.ENTER_BR,
														shiftEnterMode : CKEDITOR.ENTER_P,
														toolbarGroups : [
																/*
																	{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
																	{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
																	{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
																	{ name: 'forms' },
																	'/',*/

																{
																	name : 'document',
																	groups : [
																			'mode',
																			'document',
																			'doctools' ]
																},
																{
																	name : 'basicstyles',
																	groups : [
																			'basicstyles',
																			'cleanup' ]
																},
																{
																	name : 'paragraph',
																	groups : [
																			'list',
																			'indent',
																			'blocks',
																			'align',
																			'bidi' ]
																},
																{
																	name : 'links'
																},
																{
																	name : 'insert'
																},
																'/',
																{
																	name : 'styles'
																},
																{
																	name : 'colors'
																},
																{
																	name : 'tools'
																},
																{
																	name : 'others'
																},
																{
																	name : 'about'
																} ]
													});

									//이미지 업로드
									CKEDITOR
											.on(
													'dialogDefinition',
													function(ev) {
														var dialogName = ev.data.name;
														var dialogDefinition = ev.data.definition;

														switch (dialogName) {
														case 'image': //Image Properties dialog
															//dialogDefinition.removeContents('info');
															dialogDefinition
																	.removeContents('Link');
															dialogDefinition
																	.removeContents('advanced');
															break;
														}
													});
								</script>
							</td>
						</tr>

					</table>
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td align="center">
								<input type="image" src="${ pageContext.request.contextPath }/resources/img/btn_reg.gif" onClick="send(this.form); return false;" style="cursor: hand"> 
								<img src="${ pageContext.request.contextPath }/resources/img/btn_back.gif" onClick="location.href='list.do'" style="cursor: hand">
							</td>
						</tr>
					</table>

					<input type="hidden" name="ip" value="">

				</form>
			</td>
		</tr>
	</table>
</body>

</html>