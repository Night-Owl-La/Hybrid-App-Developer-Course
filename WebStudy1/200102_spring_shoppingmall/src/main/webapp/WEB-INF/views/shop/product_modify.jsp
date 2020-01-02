<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/product.css" />

<title>Insert title here</title>
<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	var regular_p_num = /^[a-zA-Z]{1,3}[0-9]{1,}$/;
	var regular_price = /^[0-9]{1,}$/;

	window.onload = function() {
		//var category = document.getElementById("category");
		
		if ('${ vo.category eq "com001"}' == 'true') {
			//category[1].selected = true;
			$("#category").children().eq(1).attr("selected",true);
		} else if ('${ vo.category eq "ele002"}' == 'true') {
			//category[2].selected = true;
			$("#category").children().eq(2).attr("selected",true);
		} else if ('${ vo.category eq "sp003"}' == 'true') {
			//category[3].selected = true;
			$("#category").children().eq(3).attr("selected",true);
		}

	};
	
	$(function() {
		$('.images').change(function() {
			preview(this);
		});
	});
	
	function preview(value) {
		var p_id = $('#preview_'+value.name);
		
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e) {
				p_id.attr('src', e.target.result);
				p_id.width('150px');
			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	function send(form) {

		if (checkdata(form) == false) {
			return;
		}

		form.idx.disabled = false;
		form.p_num.disabled = false;

		alert('suceess');

		form.submit();
	}
	
	function checkdata(f) {

		var p_content = CKEDITOR.instances.p_content.getData();

		if (f.p_name.value == '') {
			alert('상품 이름이 비어있습니다.');
			f.p_name.value = '';
			f.p_name.focus();
			return false;
		}

		if (f.p_company.value == '') {
			alert('상품 판매자가 비어있습니다.');
			f.p_company.value = '';
			f.p_company.focus();
			return false;
		}

		if (regular_price.test(f.p_price.value) == false) {
			alert('상품 원가가 비정상 입력.');
			f.p_price.value = '';
			f.p_price.focus();
			return false;
		}

		if (regular_price.test(f.p_saleprice.value) == false) {
			alert('상품 할인가격 비정상 입력.');
			f.p_saleprice.value = '';
			f.p_saleprice.focus();
			return false;
		}

		if (p_content == '') {
			alert('상품 내용가 비어있습니다.');
			f.p_content.value = '';
			f.p_content.focus();
			return false;
		}

		/* if (f.p_image_s.value == '') {
			alert('상품 이미지 S가 비어있습니다.');
			f.p_image_s.value = '';
			f.p_image_s.focus();
			return false;
		}

		if (f.p_image_l.value == '') {
			alert('상품 이미지 L가 비어있습니다.');
			f.p_image_l.value = '';
			f.p_image_l.focus();
			return false;
		} */

		return true;
	}
	
</script>
</head>
<body>

	<jsp:include page="index.jsp" />
	
	
	
	<div id="main_box" style="height: 100%;">
		<form action="product_modify.do" method="post" enctype="multipart/form-data">
			<table id="product_table" class="table table-bordered table-hover">
				<caption class="alert alert-info" style="text-align: center; margin-bottom: 0px; background: #a1cee5;">
					<h1>::: 상품 정보 수정 :::</h1>
				</caption>
				<tbody>
					<tr>
						<th>Product idx</th>
						<td><input type="text" name="idx" value="${ vo.idx }"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<th>Category</th>
	
						<td>
							<select name="category" id="category" >
								<option value="">카테고리 선택</option>
								<option value="com001">컴퓨터</option>
								<option value="ele002">가전제품</option>
								<option value="sp003">스포츠</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>Product Number</th>
						<td><input type="text" name="p_num" value="${ vo.p_num }"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<th>Product Name</th>
						<td><input type="text" name="p_name" value="${ vo.p_name }" /></td>
					</tr>
					<tr>
						<th>Product Company</th>
						<td><input type="text" name="p_company"
							value="${ vo.p_company }" /></td>
					</tr>
					<tr>
						<th>Product Price</th>
						<td><input type="text" name="p_price" value="${ vo.p_price }" /></td>
					</tr>
					<tr>
						<th>Product Sale price</th>
						<td><input type="text" name="p_saleprice" value="${ vo.p_saleprice }" /></td>
					</tr>
					<tr>
						<th>Product content</th>
						<td><TEXTAREA name="p_content" rows="5" cols="50">${ vo.p_content }</TEXTAREA></td>
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
						
									{ name: 'document', groups: ['mode', 'document', 'doctools'] },
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
					</tr>
					<tr>
						<th>Image S</th>
						<td>
							<span style="display: block;">
								<label for="p_image_s" class="btn btn-info">파일등록</label>
							</span>
							<input type="file" name="files" id="p_image_s" class="images">
							<div>미리보기</div>
							<img id="preview_p_image_s" src="${ pageContext.request.contextPath }/resources/images/${ vo.p_image_s }" style="width: 150px;">
						</td>
						
					</tr>
					<tr>
						<th>Image L</th>
						<td>
							<span style="display: block;">
								<label for="p_image_l" class="btn btn-info">파일등록</label>
							</span>
							<input type="file" name="files" id="p_image_l" class="images">
							<div>미리보기</div>
							<img id="preview_p_image_l" src="${ pageContext.request.contextPath }/resources/images/${ vo.p_image_l }" style="width: 150px;">
						</td>
					</tr>
	
					<tr>
						<td class="alert alert-info"colspan="2" style="text-align: center;">
						<input type="button" value="수정" class="btn btn-primary" onclick="send(this.form);" />
						<input type="button" value="취소" class="btn btn-warning" onclick="location.href='product_list.do'" /></td>
					</tr>
					
				</tbody>


			</table>
		</form>
		
		<div id="bottom" class="alert alert-info">
		
		</div>

	</div>

</body>
</html>