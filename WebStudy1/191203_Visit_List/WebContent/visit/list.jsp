<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/visit.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modify(form) {
		var pwd = form.pwd.value;
		var c_pwd = form.c_pwd.value;

		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다.');
			form.c_pwd.value = '';
			form.c_pwd.focus();
			return;
		}
		
		if(confirm('정말 수정합니까?')==false){
			return;
		}

		form.action = "modify_form.do";
		form.submit();
	}
	
	function del(form) {
		var pwd = form.pwd.value;
		var c_pwd = form.c_pwd.value;

		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다.');
			form.c_pwd.value = '';
			form.c_pwd.focus();
			return;
		}
		
		if(confirm('정말 삭제합니까?')==false){
			return;
		}

		form.action = "delete.do";
		form.submit();
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>::: 방명록 보기 :::</h1>
		<div>
			<input type="button" name="" value="방명록 쓰기" onclick="location.href='insert_form.do'" class="btn btn-primary">
		</div>

		<!-- 데이터가 없을 때 -->
		<c:if test="${ empty list }">
			<div id="empty_message">작성된 게시글이 없습니다.</div>
		</c:if>

		<!-- 데이터가 있을 때.  -->
		<c:forEach var="item" items="${ list }">
			<div class="content_box">
				<div class="content">${ item.content }</div>
				<div class="name">글작성자: ${ item.name } ${ item.ip }</div>
				<div class="regdate">작성일자: ${ fn:substring(item.regdate, 0,16) }</div>
				<div>
					<form>
						<input type="hidden" name="idx" value="${ item.idx }"/>
						<input type="hidden" name="pwd" value="${ item.pwd }"/>
						비밀번호: ${ item.pwd } <input type="password" name="c_pwd"/>
						<input type="button" value="수정" onclick="modify(this.form);" class="btn btn-info"/> 
						<input type="button" value="삭제" onclick="del(this.form);" class="btn btn-danger" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
