<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/photo.css" />
	
<script src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	// 팝업 박스 초기화.
	window.onload = function() {
		var popup = document.getElementById("popup_box");
		
		var body_width = window.innerWidth;
		var body_height = window.innerHeight;
		var popup_width = 320;
		var popup_height = 420;
		
		//브라우저 정중앙으로 위치.
		popup.style.left = (body_width/2 - popup_width/2 ) + "px";
		popup.style.top = (body_height/2 - popup_height/2) + "px";
	}
	
	// 팝업창 닫기.
	function popup_close() {
		document.getElementById("popup_box").style.display="none";	
	}
	
	function show_popup(p_idx) {
		
		//document.getElementById("popup_box").style.display='block';
		$("#popup_box").show();
		
		$.ajax({
			url : 'photo_one.do',
			data : {'p_idx' : p_idx},
			dataType : 'json',
			success : function(res_data) {
				$("#pop_p_file").attr("src", "${pageContext.request.contextPath}/upload/"+res_data.p_filename);
				$("#pop_p_file").attr("width", "298px");
				$("#pop_p_file").attr("height", "298px");
				$("#pop_p_subject").html("파일명 : "+res_data.p_subject);
				$("#pop_p_content").html("파일내용 : "+res_data.p_content);
			}
		});
	}
	
	//파일 업로드.
	function upload(){
		if("${ empty user }"=="true"){
			if(confirm('로그인 후 이용 할 수 있습니다\n로그인 하시겠습니까?')==false) return;
			location.href='${ pageContext.request.contextPath }/member/login_form.do';
			return;
		}else{
			location.href="insert_form.do";
		}
	}
	
	//파일 다운로드.
	function download(filename) {
		if("${ empty user }"=="true"){
			if(confirm('로그인 후 이용 할 수 있습니다\n로그인 하시겠습니까?')==false) return;
			location.href='${ pageContext.request.contextPath }/member/login_form.do';
			return;
		}else{
			location.href="../FileDownload.do?dir=/resources/upload/&filename=" + encodeURIComponent(filename);
		}
	}
	
	//파일 삭제.
	function photo_delete(p_idx) {
		if(confirm('정말 삭제합니까?')==false){
			return;
		}
		if(confirm('삭제하면 데이터를 되돌릴 수 없습니다. 삭제합니까?')==false){
			return;
		}
		location.href='delete.do?p_idx='+p_idx;
	}
	
	
</script>
</head>
<body>
	<%@ include file="photo_popup.jsp" %>
	<div id="main_box">
		<div id="title_box" class="alert alert-info">
			<h1 id="title">:::포토 갤러리:::</h1>
		</div>
		<div id="option_box" class="alert alert-success">
			
			<c:if test="${ empty sessionScope.user }">
				<input type="button" value="로그인" class="btn btn-success" onclick="location.href='${ pageContext.request.contextPath }/member/login_form.do'" />
				<input type="button" value="회원가입" class="btn btn-info" onclick="location.href='${ pageContext.request.contextPath }/member/insert_form.do'" />
			</c:if>
			<c:if test="${ not empty user }">
				${ user.name } idx:${ user.idx } 로그인 완료.
				<input type="button" value="로그아웃" class="btn btn-warning" onclick="location.href='${ pageContext.request.contextPath }/member/logout.do'" />
			</c:if>

			<div id="btn-upload">
				<input type="button" value="회원관리" class="btn btn-default" onclick="location.href='${ pageContext.request.contextPath }/member/list.do'"/>
				<input type="button" value="업로드" class="btn btn-primary" onclick="upload();"/>
			</div>
		
		</div>
		
		<div id="photo_box" class="alert alert-info">
		
			<c:if test="${ empty list }">
				<div id="empty_message">사진이 없습니다.</div>
			</c:if>
			<c:forEach var="photo" items="${ list }">
				<div class="photo_type">
					<img src="${ pageContext.request.contextPath }/resources/upload/${ photo.p_filename }" onclick="show_popup('${ photo.p_idx}');" />
					<div class="subject">${ photo.p_subject }</div>
					<div class="content">${ photo.p_content }</div>
					<div>upload idx : ${ photo.m_idx }</div>
					<div>
						<input type="button" class="btn btn-default" value="다운로드" onclick="download('${ photo.p_filename}');" />
					</div>
					
					<c:if test="${ photo.m_idx == user.idx }">
						<div>
							<input type="button" class="btn btn-danger" value="삭제" onclick="photo_delete('${ photo.p_idx }');" />
						</div>
					</c:if>
				</div>
			</c:forEach>
		</div>

	</div>

</body>
</html>