<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/photo.css" />

<script type="text/javascript">
	function upload(){
		if("${ empty user }"=="true"){
			if(confirm('로그인 후 이용 할 수 있습니다\n로그인 하시겠습니까?')==false) return;
			location.href='${ pageContext.request.contextPath }/member/login_form.do';
		}else{
			location.href="insert_form.do";
		}
	}
</script>
</head>
<body>
	<div id="main_box">
		<div id="title_box">
			<h1 id="title">:::포토 갤러리:::</h1>
		</div>
		<div id="option_box">
			
			<c:if test="${ empty sessionScope.user }">
				<input type="button" value="로그인" class="btn btn-success" onclick="location.href='${ pageContext.request.contextPath }/member/login_form.do'" />
				<input type="button" value="회원가입" class="btn btn-info" onclick="location.href='${ pageContext.request.contextPath }/member/insert_form.do'" />
			</c:if>
			<c:if test="${ not empty user }">
				${ user.name } 로그인 완료.
				<input type="button" value="로그아웃" onclick="location.href='${ pageContext.request.contextPath }/member/logout.do'" />
			</c:if>

			<div id="btn-upload">
				<input type="button" value="업로드" class="btn btn-primary" onclick="upload();"/>
			</div>
		
		</div>
		
		<div id="photo_box">
		
			<c:if test="${ empty list }">
				<div id="empty_message">사진이 없습니다.</div>
			</c:if>
			<c:forEach var="photo" items="${ list }">
				<div class="photo_type">
					<img src="${ pageContext.request.contextPath }/upload/${ photo.p_filename }" />
					<div class="subject">${ photo.p_subject }</div>
					<div class="content">${ photo.p_content }</div>
					<div>
						<input type="button" class="btn btn-default" value="다운로드" />
					</div>
				</div>
			</c:forEach>
		</div>

	</div>

</body>
</html>