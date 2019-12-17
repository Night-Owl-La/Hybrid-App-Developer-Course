<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/product.css" />
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function send_Cart(p_idx, m_idx) {
		$.ajax({
			url : 'cart_Insert.do',
			data : {
					'p_idx' : p_idx,
					'm_idx' : m_idx
				},
			dataType : 'json',
			success : function(res_data) {
				alert('장바구니 담기 완료!');
			},
			error : function(error) {
				alert('에러! : '+error);
			}
			
		});
	}
</script>
</head>
<body>

	<jsp:include page="index.jsp" />
	
	<div id="main_box" style="height: 100%;">
		<table id="product_table" class="table table-bordered table-hover">
			<tbody style="width: 800px;">
				<tr>
					<th>제품분류</th>
					<td>${ vo.category }</td>
				</tr>
				<tr>
					<th>제품번호</th>
					<td>${ vo.p_num }</td>
				</tr>
				<tr>
					<th>제품명</th>
					<td>${ vo.p_name }</td>
				</tr>
				<tr>
					<th>제조사</th>
					<td>${ vo.p_company }</td>
				</tr>
				<tr>
					<th>제품가격</th>
					<td>
						<fmt:formatNumber type="currency" value="${ vo.p_price }" /> 
						(할인가:<fmt:formatNumber type="currency" value="${ vo.p_saleprice }" />)
					</td>
				</tr>
				<tr>
					<th colspan="2">제품설명</th>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding: 0px;"><img src="${ pageContext.request.contextPath}/images/${ vo.p_image_l }" width="800px"></td>
				</tr>
				<tr>
					<td colspan="2">${ vo.p_content }</td>
				</tr>
				<c:if test="${ not empty user }">
					<tr class="alert alert-info">
						<td colspan="2" align="center">
							<input type="button" class="btn btn-primary" value="장바구니에 담기" onclick="send_Cart('${ vo.idx }', '${ user.idx }');" />
							<input type="button" class="btn btn-info" value="장바구니 보기" onclick="location.href='cart_list.do'" />
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		
		<div id="bottom" class="alert alert-info">
		
		</div>
	</div>
</body>
</html>