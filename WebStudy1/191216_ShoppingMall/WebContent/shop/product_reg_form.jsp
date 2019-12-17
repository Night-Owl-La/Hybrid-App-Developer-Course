<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/product.css" />

<title>Insert title here</title>

<script type="text/javascript">
	
	var regular_p_num = /^[a-zA-Z]{1,3}[0-9]{1,}$/;
	var regular_price = /^[0-9]{1,}$/;
	
	
	function checkdata(f) {
		
		if(f.category.value == ''){
			alert('상품 카테고리가 비어있습니다.');
			f.category.value='';
			f.category.focus();
			return;
		}
		
		if(regular_p_num.test(f.p_num.value)==false){
			alert('상품 번호를 제대로 입력해주세요.');
			f.p_num.value='';
			f.p_num.focus();
			return;
		}

		if(f.p_name.value == ''){
			alert('상품 이름이 비어있습니다.');
			f.p_name.value='';
			f.p_name.focus();
			return;
		}
		
		if(f.p_company.value == ''){
			alert('상품 판매자가 비어있습니다.');
			f.p_company.value='';
			f.p_company.focus();
			return;
		}
		
		if(regular_price.test(f.p_price.value)==false){
			alert('상품 원가가 비정상 입력.');
			f.p_price.value='';
			f.p_price.focus();
			return;
		}
		
		if(regular_price.test(f.p_saleprice.value)==false){
			alert('상품 할인가격 비정상 입력.');
			f.p_saleprice.value='';
			f.p_saleprice.focus();
			return;
		}
		
		if(f.p_content.value == ''){
			alert('상품 내용가 비어있습니다.');
			f.p_content.value='';
			f.p_content.focus();
			return;
		}
		
		if(f.p_image_s.value == ''){
			alert('상품  이미지 S가 비어있습니다.');
			f.p_image_s.value='';
			f.p_image_s.focus();
			return;
		}
		
		if(f.p_image_l.value == ''){
			alert('상품 이미지L가 비어있습니다.');
			f.p_image_l.value='';
			f.p_image_l.focus();
			return;
		}
		
		f.submit();

	}
</script>
</head>
<body>

	<!-- title -->
	<jsp:include page="index.jsp" />

	<form name="f" method="post" action="product_insert.do"
		enctype="multipart/form-data">
		<div id="main_box" style="height: 100%;">
			<table id="product_table" class="table table-bordered table-hover">
				<tbody>
					<tr>
						<th>제품Category</th>
						<td><select name="category">
								<option value="">카테고리 선택</option>
								<option value="com001">컴퓨터</option>
								<option value="ele002">가전제품</option>
								<option value="sp003">스포츠</option>
						</select></td>
					</tr>
					<tr>
						<th>제품번호</th>
						<td><input name="p_num" type="text"></td>
					</tr>
					<tr>
						<th>제품이름</th>
						<td><input name="p_name" type="text"></td>
					</tr>
					<tr>
						<th>제품 판매사</th>
						<td><input name="p_company" type="text"></td>
					</tr>
					<tr>
						<th>제품가격</th>
						<td><input name="p_price" type="text"></td>
					</tr>
					<tr>
						<th>제품할인가격</th>
						<td><input name="p_saleprice" type="text"></td>
					</tr>
					<tr>
						<th>제품설명</th>
						<td><TEXTAREA name="p_content" rows="5" cols="50"></TEXTAREA></td>
					</tr>
					<tr>
						<th>제품사진 (작은사진)</th>
						<td><input type="file" name="p_image_s">
					</tr>
					<tr>
						<th>제품사진 (큰사진)</th>
						<td><input type="file" name="p_image_l">
					</tr>
					<tr>
						<td class="alert alert-info" colspan="2" align="center">
							<input type="button" class="btn btn-primary" value="등록" onclick="checkdata(this.form);"> 
							<input type="reset" class="btn btn-default" value="Clear">
						</td>
					</tr>
				</tbody>
			</table>
			<div id="bottom" class="alert alert-info">
			</div>
		</div>

	</form>
</body>
</html>