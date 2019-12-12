<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/member.css" />
<script type="text/javascript">
	function del(idx) {
		if(confirm('정말 삭제합니까?')==false){
			return;
		}
		if(confirm('삭제하면 데이터를 되돌릴 수 없습니다. 삭제합니까?')==false){
			return;
		}
		
		location.href='delete.do?idx='+idx;
	}
</script>
</head>
<body>
	<div class="list_main_box">
		<table class="table table-bordered table-hover member_table_box">
	
			<caption class="alert alert-info">
				<h1>::: 회원 목록 :::</h1>
			</caption>
			
			<tbody class="alert alert-success">
				<tr>
					<th>일련번호</th>
					<th>이름</th>
					<th>ID</th>
					<th>PWD</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>IP</th>
					<th>가입일자</th>
					<th>수정일자</th>
					<th>회원구분</th>
					<th>비고</th>
				</tr>
		
				<!-- 0. 데이터가 없을 때. -->
				<c:if test="${ empty list }">
					<tr>
						<td align="center" colspan="11">등록된 회원이 없습니다.</td>
					</tr>
				</c:if>
		
				<!-- 0. 데이터가 있을 때. -->
				<c:forEach var="member" items="${ list }">
					<tr>
						<td>${ member.idx }</td>
						<td>${ member.name }</td>
						<td>${ member.id }</td>
						<td>${ member.pwd }</td>
						<td>${ member.zipcode }</td>
						<td>${ member.address }</td>
						<td>${ member.ip }</td>
						<td>${ fn:substring(member.regdate,0,10) }</td>
						<td>${ fn:substring(member.modifydate,0,10) }</td>
						<td>${ member.grade }</td>
						<td><input type="button" value="수정" class="btn btn-success" onclick="location.href='modify_form.do?idx='+${member.idx}" />
							<input type="button" value="삭제" class="btn btn-danger" onclick="del(${member.idx});" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<div class="alert alert-info" style="width: 100%;">
			<input type="button" value="회원가입" class="btn btn-default" onclick="location.href='insert_form.do'"/>
			<input type="button" value="포토갤러리" class="btn btn-info" onclick="location.href='${ pageContext.request.contextPath}/photo/list.do'"/>
		</div>
	</div>
</body>
</html>
