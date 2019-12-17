<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/member.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	window.onload = function() {
		setTimeout(init, 100);
	}
	
	function init() {
		
		if("${ param.reason eq 'fail_id'}" == 'true'){
			alert('아이디가 틀립니다');
		}
		
		if("${ param.reason eq 'fail_pwd'}" == 'true'){
			alert('비밀번호가 틀립니다');
		}
		
		// 다른 페이지에서 미로그인으로 인한 핸들링 요청시.
		var hashes = window.location.href.slice(window.location.href.indexOf('=') + 1).split('&');
		if(hashes == 'fail_cart_not_login'){
			alert('로그인후 이용해주세요!');			
		}
	}
	
	function send(form) {

		if (form.id.value == '') {
			alert('아이디를 입력하세요.');
			return;
		}

		if (form.pwd.value == '') {
			alert('비밀번호를 입력하세요.');
			return;
		}

		form.submit();
	}
</script>
</head>
<body>
	<div class="main_box">
		<form action="login.do">
			<table  class="table table-bordered table-hover member_signup_box">
				<caption><h1>:::로그인:::</h1></caption>
				
				<tr>
					<th>ID</th>
					<td>
						<input name="id" id="id" />
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input id="btn_signin" type="button" value="로그인" class="btn btn-success" onclick="send(this.form);"/>
						<input type="button" value="취소" class="btn btn-warning" onclick="location.href='${ pageContext.request.contextPath }/shop/product_list.do';"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input id="btn_signup" type="button" value="회원가입" class="btn btn-success" onclick="location.href='${ pageContext.request.contextPath }/member/insert_form.do'"/>
					</td>
				
				</tr>
			</table>
		</form>
	</div>

</body>
</html>