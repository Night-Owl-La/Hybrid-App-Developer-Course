<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/comment.css" type="text/css">
</head>
<body>
<article id="wrap_list_comment">
	<c:forEach var="vo" items="${ list }">
		<div id="list_comment">
			<div class="box_content_comment">
				<span class="author_content_comment">${ vo.user_name }</span>
				<span class="regdate_content_comment">
					${ fn:substring(vo.comment_regdate,0,16) }
					<c:if test="${ user.idx eq vo.user_idx}">
						<input class="btn btn-danger" type="button" value="X" onclick="comment_del(${ vo.comment_idx}, ${ vo.board_idx });" />
					</c:if>
				</span>
				<div class="main_content_comment">내용 : ${ vo.comment_content }</div>
			</div>
			<hr />
		</div>
	</c:forEach>
</article>
<div id="paging_comment">
	${ pageMenu }
</div>

</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function comment_del(comment_idx, board_idx) {
		if(confirm('정말 삭제합니까?')=='false'){
			return;
		}
		
		$.ajax({
			url: '${pageContext.request.contextPath}/comment/delete.do',
			data: {	'comment_idx':comment_idx },
			dataType: 'json',
			success: function(res_data) {
				if(res_data.result != 'success'){
					alert('댓글 삭제 실패');
					return;
				}
				alert('댓글 삭제 성공');
				location.href='${pageContext.request.contextPath}/board/view.do?idx='+board_idx;
			},
			error: function(error) {
				alert(error);
			}
			
		});
	}
</script>
</html>