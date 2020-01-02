<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/product.css" />
<title>Insert title here</title>
<script type="text/javascript">
	
	function del(c_idx) {
		if(confirm('정말 삭제하시겠습니까?')==false){
			return;
		}
		
		location.href="cart_delete.do?c_idx="+c_idx;
	}
	
</script>
</head>
<jsp:include page="index.jsp" />
<body>
	<div id="main_box" style="height: 100%;">
		<table id="product_table" class="table table-bordered table-hover">
			<tr>
				<td colspan="6">:: 장바구니 내용</td>
			</tr>
			<tr class="alert alert-info">
				<th>제품번호</th>
				<th width="25%">제품명</th>
				<th>단가</th>
				<th>수량</th>
				<th>금액</th>
				<th>삭제</th>
			</tr>
			
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6" align="center">장바구니가 비어있습니다.</td>
				</tr>
			</c:if>
	
			<c:forEach var="cart" items="${ list }">
				<tr align="center">
					<td>${ cart.p_num }</td>
					<td>${ cart.p_name }</td>
					<td>단가:${ cart.p_price }<br> 
					<span style="color: red;">세일가격:${ cart.p_saleprice }</span>
					</td>
					<td>
						<!-- 수량 조정 폼 -->
						<form action="cart_update.do" method="post">
							<input type="hidden" name="c_idx" value="${ cart.c_idx }"> 
							<input name="c_cnt" size="4" align="center" value="${ cart.c_cnt }">
							<input type="submit" class="btn btn-warning" value="수정">
						</form>
					</td>
					<td><fmt:formatNumber type="currency" value="${ cart.amount }"/></td>
					<td>
						<input type="button" class="btn btn-danger" value="삭제" style="cursor: hand" onclick="del('${ cart.c_idx }');">
					</td>
				</tr>		
		
			</c:forEach>
				<tr>
					<td colspan="5" align="right">총 결재액 :</td>
					<td><fmt:formatNumber type="currency" value="${ amount }"/></td>
				</tr>
		</table>
		<div id="bottom" class="alert alert-info">
		
		</div>
	</div>
</body>
</html>






