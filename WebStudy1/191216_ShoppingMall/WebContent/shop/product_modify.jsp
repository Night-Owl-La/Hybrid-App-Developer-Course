<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(form) {

		form.idx.disabled = false;
		form.p_num.disabled = false;
		
		alert('suceess');
		
		form.submit();
	}
</script>
</head>
<body>

	<div class="main_box">
		<form action="product_modify.do">
			<table class="table table-bordered table-hover member_modify_box">
				<caption>
					<h1>::: 회원 정보 수정 :::</h1>
				</caption>
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
					<td><input type="text" name="p_saleprice"
						value="${ vo.p_saleprice }" /></td>
				</tr>
				<tr>
					<th>Product content</th>
					<td><input type="text" name="p_content"
						value="${ vo.p_content }" /></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;">
					<input type="button" value="수정" class="btn btn-success" onclick="send(this.form);" />
					<input type="button" value="취소" class="btn btn-warning" onclick="location.href='product_list.do'" /></td>
				</tr>


			</table>
		</form>

	</div>

</body>
</html>