<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/member.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	var regular_id = /^[a-zA-Z0-9]{3,8}$/;
	

	// id중복 체크.
	$(function() {
		$("#btn_id_check").click(function() {

			var id = $("#id").val().trim();

			if (regular_id.test(id) == false) {
				alert('3자리 이상 영문,숫자 혼합으로 입력하세요.');
				$('#id').val('');
				$('#id').focus();

				return;
			}

			$.ajax({
				url : 'check_id.do',
				data : {
					'id' : id
				},
				dataType : 'json',
				success : function(res_data) {
					if (res_data.result == false) {
						alert('이미 존재하는 아이디 입니다.');
						return;
					} else {
						alert('사용가능한 아이디 입니다.');
						$('#btn_signup').attr("disabled",false);
						$('#id').attr("readonly", true);
					}
				},
				error : function(error) {
					console.log(error);
				}
			}); //ajax end.
			
		});//btn_id_check.click end.
	});// jquery end.
	
	//주소 찾기.
	function find_address(){
	    new daum.Postcode({	//Daum 우편번호 찾기 서비스 API.
	        oncomplete: function(res_data) {
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
		
		if(form.id.value==''){
			alert('아이디를 입력하세요.');
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
		
		alert('success');
		
		form.submit();
	}
	
</script>
</head>
<body>
	<div class="main_box">
		<form action="insert.do">
			<table  class="table table-bordered table-hover member_signup_box">
				<caption><h1>:::회원가입:::</h1></caption>
				
				<tr>
					<th>이름</th>
					<td><input name="name" /></td>
				</tr>
				<tr>
					<th>ID</th>
					<td>
						<input name="id" id="id" />
						<input id="btn_id_check" type="button" value="중복체크" class="btn btn-success"/>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input name="zipcode" id="zipcode" />
						<input type="button" value="주소찾기" class="btn btn-info" onclick="find_address();" />
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input name="address" id="address" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>회원구분</th>
					<td>
						<input type="radio" name="grade" value="일반">일반
						<input type="radio" name="grade" value="관리자">관리자
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input id="btn_signup" type="button" value="가입" disabled="disabled" class="btn btn-success" onclick="send(this.form);"/>
						<input type="button" value="취소" class="btn btn-warning" onclick="location.href='${ pageContext.request.contextPath}/board/list.do';"/>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>