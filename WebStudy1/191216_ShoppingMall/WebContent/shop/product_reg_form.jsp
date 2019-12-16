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
	function checkdata(f) {
		category = f.category.value;
		p_num = f.p_num.value;
		p_name = f.p_name.value;
		p_company = f.p_company.value;
		p_price = f.p_price.value;
		p_saleprice = f.p_saleprice.value;
		p_content = f.p_content.value;
		p_image_s = f.p_image_s.value;
		p_image_l = f.p_image_l.value;

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
				<tbody class="alert alert-success">
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
						<th>제품사진(작은사진)</th>
						<td><input type="file" name="p_image_s">
					</tr>
					<tr>
						<th>제품사진(큰사진)</th>
						<td><input type="file" name="p_image_l">
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							value="등록" onclick="javascript:checkdata(this.form);"> <input
							type="reset" value="Clear"></td>
					</tr>
				</tbody>
			</table>
			<div id="bottom" class="alert alert-info">
			</div>
		</div>

	</form>
</body>
</html>