<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/member.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

	function find_address() {
		new daum.Postcode({ //Daum 우편번호 찾기 서비스 API.
			oncomplete : function(res_data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
				$('#zipcode').val(res_data.zonecode);
				$('#address').val(res_data.roadAddress);
			}
		}).open();
	}
	
	function send(form) {

		if(form.name.value==''){
			alert('이름을 입력하세요.');
			return;
		}
		
		if(form.pwd.value==''){
			alert('비밀번호를 입력하세요.');
			return;
		}
		
		if(form.address.value==''){
			alert('주소를 입력하세요.');
			return;
		}
		
		if(form.grade.value==''){
			alert('회원 구분을 선택하세요.');
			return;
		}
		
		form.idx.disabled=false;
		form.id.disabled=false;
		form.regdate.disabled=false;
		form.modifydate.disabled=false;
		
		alert('success');
		
		form.submit();
	}
</script>
</head>
<body>

	<div class="main_box">
		<form action="modify.do">
			<table class="table table-bordered table-hover member_modify_box">
			<caption><h1>::: 회원 정보 수정 :::</h1></caption>
				<tr>
					<th>일련번호</th>
					<td><input type="text" name="idx" value="${ vo.idx }" disabled="disabled" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${ vo.name }" /></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="${ vo.id }" disabled="disabled"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${ vo.pwd }" /></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" id="zipcode" name="zipcode" value="${ vo.zipcode }" />
					<input type="button" value="주소찾기" class="btn btn-info" onclick="find_address();" /></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" id="address" name="address" value="${ vo.address }" /></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="regdate" value="${ fn:substring(vo.regdate,0,10) }" disabled="disabled"/></td>
				</tr>
				<tr>
					<th>수정일자</th>
					<td><input type="text" name="modifydate" value="${ fn:substring(vo.modifydate,0,10) }" disabled="disabled"/></td>
				</tr>
				<tr>
					<th>현재 회원구분</th>
					<td>${ vo.grade }<br>
						<input type="radio" name="grade" value="일반">일반 
						<input type="radio" name="grade" value="관리자">관리자
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="button" value="수정" class="btn btn-success" onclick="send(this.form);" />
						<input type="button" value="취소" class="btn btn-warning" onclick="location.href='list.do'" />
					</td>
				</tr>
	
	
			</table>
		</form>

	</div>

</body>
</html>