<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>목록보기</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html;">
</head>

<body>

	<!--로케이션 & 로그인끝-->
	<!--타이틀 영역-->
	<table width="700" align="center">
		<tr>
			<td>
				<table width="690" height="50" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><img src="${ pageContext.request.contextPath }/resources/img/title_04.gif"></td>
					</tr>
				</table> <!--타이틀 영역--끝-->
			</td>
		</tr>
		
		<!-- Login or Logout -->
		<tr>
			<td style="text-align: right;">
				<c:if test="${ not empty user }">
					<input type="button" value="Logout" onclick="location.href='${ pageContext.request.contextPath }/member/logout.do'" />
				</c:if>
				
				<c:if test="${ empty user }">
					<input type="button" value="Login" onclick="location.href='${ pageContext.request.contextPath }/member/login_form.do'" />
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>
				<!--LIST START-->
				<table width="690" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table width="690" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50" class="td_a">번호</td>
									<td width="2" class="td_b"><img src="${ pageContext.request.contextPath }/resources/img/td_bg_01.gif"></td>
									<td class="td_b" width="300">제목</td>
									<td width="2" class="td_b"><img src="${ pageContext.request.contextPath }/resources/img/td_bg_01.gif"></td>
									<td width="90" class="td_b">작성자</td>
									<td width="2" class="td_b"><img src="${ pageContext.request.contextPath }/resources/img/td_bg_01.gif"></td>
									<td width="90" class="td_b">작성일</td>
									<td width="2" class="td_b"><img src="${ pageContext.request.contextPath }/resources/img/td_bg_01.gif"></td>
									<td width="60" class="td_c">조회수</td>
								</tr>
								
								<c:forEach var="vo" items="${ list }">
									<tr>
										<td align="center" class="td_a_1">${ vo.board_idx }</td>
										<td class="td_b_1">
											<img src="${ pageContext.request.contextPath }/resources/img/td_bg_02.gif">
										</td>
										<td class="td_b_1 left">
												<c:forEach begin="1" end="${ vo.reference_depth }">&nbsp;&nbsp;</c:forEach>
												<!-- 답글이면 ㄴ 붙이기 -->
												<c:if test="${ vo.reference_depth != 0 }">ㄴ</c:if>
												
												<!-- 사용중인 게시물이면 -->
												<c:if test="${ vo.board_use_yn eq 'y' }">
													<a href="view.do?idx=${ vo.board_idx }&page=${ (empty param.page) ? 1: param.page }&search=${ param.search}&search_text=${ param.search_text }" class="num">
														${ vo.board_title }
														(${ vo.comment_count })
													</a>
												</c:if>
												
												<!-- 사용하지 않는 게시물이면 -->
												<c:if test="${ vo.board_use_yn eq 'n' }">
													<span style="color: tomato">삭제된 게시물입니다.</span>
												</c:if>
											</td>
										<td class="td_b_1">
											<img src="${ pageContext.request.contextPath }/resources/img/td_bg_02.gif">
										</td>
										<td align="center" class="td_b_1">${ vo.user_name }</td>
										<td class="td_b_1">
											<img src="${ pageContext.request.contextPath }/resources/img/td_bg_02.gif">
										</td>
										<td align="center" class="td_b_1">${ fn:substring(vo.board_regdate, 0, 10) }</td>
										<td class="td_b_1">
											<img src="${ pageContext.request.contextPath }/resources/img/td_bg_02.gif">
										</td>
										<td align="center" class="td_c_1">${ vo.board_view_count }</td>
									</tr>
								</c:forEach>

								<!-- 게시글이 없는 경우 -->
								<c:if test="${ empty list }">
									<tr>
										<td align="center" colspan="11" width="100%" height="50"
											style="border: 1 solid #efefef">현재 등록된 글이 없습니다.</td>
									</tr>
								</c:if>

							</table>
						</td>
					</tr>
					<tr>
						<td height="8"></td>
					</tr>
					<tr>
						<td>
							<table width="690" border="0" cellpadding="0" cellspacing="0" bgcolor="#F1F5F4">
								<!-- Search Menu -->
								<tr style="text-align: center;">
									<td width="7"><img src="${ pageContext.request.contextPath }/resources/img/search_bg_01.gif"></td>
									<td class="f11">
									<select id="search">
										<option value="all">전체</option>
										<option value="title">제목</option>
										<option value="name">이름</option>
										<option value="content">내용</option>
										<option value="title_name_content">제목+이름+내용</option>
									</select>
									<input id="search_text" value="${ param.search_text }" />
									<input type="button" value="검색" onclick="search();"/>
									</td>
								</tr>
								<!-- Paging Menu -->
								<tr>
									<td width="7"><img src="${ pageContext.request.contextPath }/resources/img/search_bg_01.gif"></td>
									<td class="f11">
									${ pageMenu }
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td><img src="${ pageContext.request.contextPath }/resources/img/btn_reg.gif" onClick="insert_form();" style="cursor: hand"></td>
					</tr>

				</table> <!--WRITE,MODIFY,REPLY END-->
			</td>
		</tr>
	</table>
</body>

<!-- Script -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	$(function() {
		if("${param.search eq 'title'}" =="true"){
			$("#search").children().eq(1).attr('selected',true);	
		}else if("${param.search eq 'name'}" =="true"){
			$("#search").children().eq(2).attr('selected',true);	
		}else if("${param.search eq 'content'}" =="true"){
			$("#search").children().eq(3).attr('selected',true);	
		}else if("${param.search eq 'title_name_content'}" =="true"){
			$("#search").children().eq(4).attr('selected',true);	
		} 
	});

	function insert_form() {
		if("${ empty user}"=='true'){
			alert('로그인 후 이용 가능합니다');
			location.href='${ pageContext.request.contextPath }/member/login_form.do';
			return;
		}
		
		location.href='board_insert_form.do';
	}
	
	function search() {
		var search = $('#search').val();
		var search_text =$('#search_text').val().trim();
		
		// 전체검색이 아닐 경우.
		if(search != 'all' && search_text==''){
			$('#search_text').val('');
			$('#search_text').focus();
			return;
		}
		
		if(search=='all') search_text='';
		
		location.href='list.do?search=' + search + '&search_text=' + encodeURIComponent(search_text);
	}
	
</script>
</html>