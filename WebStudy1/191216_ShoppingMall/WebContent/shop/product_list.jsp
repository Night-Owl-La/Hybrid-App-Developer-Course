<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

function del(idx) {
	if(confirm('정말 삭제합니까?')==false){
		return;
	}
	if(confirm('삭제하면 데이터를 되돌릴 수 없습니다. 삭제합니까?')==false){
		return;
	}
	
	location.href='product_delete.do?idx='+idx;
}

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
		<table id="product_table" class="table table-bordered table-hover" >
			<tr class="alert alert-info">
				<th width="10%">제품번호</th>
				<th width="10%">이미지</th>
				<th width="35%">제품명</th>
				<th width="20%">제품가격</th>
				<th width="25%">비고</th>
			</tr>
	
			<!-- no data -->
			<c:if test="${ empty list }">
				<tr>
					<td colspan="5" align="center">
						<span>등록된 상품이 없습니다.</span>
					</td>
				</tr>
			</c:if>
			
			<!--  -->
			<c:forEach var="product" items="${ list }">
				<tr class="alert alert-success" style="font-size: 18px;">
					<td>${ product.p_num }</td>
					<td><img src="${ pageContext.request.contextPath}/images/${ product.p_image_s }" width="100" height="120"></td>
					<td><a href="product_view.do?idx=${ product.idx }">${ product.p_name }</a></td>
					<td>
						<fmt:formatNumber value="${ product.p_saleprice }"/> <br>
						<span style="color: red;">(${ product.p_discount_rate }%)</span>
					</td>
					<td>
						<fmt:formatNumber value="${ product.p_price }"/>
						<br>
						<c:if test="${ not empty user }">
							<input type="button" class="btn btn-default" value="담기" onclick="send_Cart('${ product.idx }', '${ user.idx }');" />
						</c:if>
						
						<!-- is manager -->
						<c:if test="${ user.grade == '관리자' }">
							<input type="button" class="btn btn-warning" value="수정" onclick="location.href='product_modify_form.do?idx='+${product.idx}" />
							<input type="button" class="btn btn-danger" value="삭제" onclick="del(${product.idx});" />
						</c:if>
					</td>
					
				</tr>
			</c:forEach>
	
		</table>
		<div id="bottom" class="alert alert-info">
		
		</div>
	</div>
</body>
</html>