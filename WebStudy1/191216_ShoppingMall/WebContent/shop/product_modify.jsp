<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/product.css" />

<title>Insert title here</title>

<script type="text/javascript">
	var regular_p_num = /^[a-zA-Z]{1,3}[0-9]{1,}$/;
	var regular_price = /^[0-9]{1,}$/;

	function checkdata(f) {

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

		if (f.p_content.value == '') {
			alert('상품 내용가 비어있습니다.');
			f.p_content.value = '';
			f.p_content.focus();
			return false;
		}

		return true;
	}
	
	function send(form) {
		
		if(checkdata(form)==false){
			return;
		}

		form.idx.disabled = false;
		form.p_num.disabled = false;

		alert('suceess');

		form.submit();
	}
</script>
</head>
<body>

	<jsp:include page="index.jsp" />
	
	<div id="main_box" style="height: 100%;">
		<form action="product_modify.do">
			<table id="product_table" class="table table-bordered table-hover">
				<caption class="alert alert-info" style="text-align: center; margin-bottom: 0px; background: #a1cee5;">
					<h1>::: 상품 정보 수정 :::</h1>
				</caption>
				<tbody>
					<tr>
						<th>일련번호</th>
						<td><input type="text" name="idx" value="${ vo.idx }"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<th>카테고리</th>
	
						<td>
							<select name="category" >
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
						<td><input type="text" name="p_content"
							value="${ vo.p_content }" /></td>
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