<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/comment.css" type="text/css">
</head>
<body>
	<!-- 댓글등록 폼 -->
	<div id="comment_area">
		<!-- 댓글 리스트 - ajax 삽입. -->
		<div id=disp></div>
		
		<!-- 댓글 쓰기 -->
		<div id="wrap_content">
			<div id="div_content">
				<textarea id="comment_content" class="alert-success"></textarea>
			</div>
			<div id="div_btn">
				<input id="btn_comment_insert" class="btn btn-default" type="button" value="글쓰기" />
			</div>
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function comment_list(page) {
		$.ajax({
			url: '${ pageContext.request.contextPath }/comment/list.do',
			data: {'board_idx': '${ vo.board_idx}',
					'page': page	},
			success:function(res_data){
				$('#disp').html(res_data);
				
			},
			error:function(error){
				alert(error);
			}
			
		});
	}
	
	function write_comment() {
		var content = $('#comment_content').val().trim();
		
		if("${ empty user }"=="true"){
			alert('댓글은 로그인 후 이용 가능합니다.');
			location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href;
			return;
		}
		
		if( content == ''){
			alert('내용을 입력해 주세요.');
			$('#comment_content').val('');
			$('#comment_content').focus();
			return;
		}
		
		$.ajax({
			url: '${ pageContext.request.contextPath }/comment/insert.do',
			data: {	'comment_content': content, 
					'user_idx': '${ user.idx }',
					'user_name': '${ user.name }',
					'board_idx': '${ vo.board_idx }'},
			dataType: 'json',
			success: function(res_data) {
				if(res_data.result != 'success'){
					alert('댓글쓰기 실패');
					return;
				}
				$('#comment_content').val('');
				comment_list(1);
			},
			error: function(error) {
				alert(error);
			}
		});
	}
	
	$(function() {
		comment_list(1);
		
		$('#btn_comment_insert').click(function() {
			write_comment();			
		})
	})
</script>
</html>