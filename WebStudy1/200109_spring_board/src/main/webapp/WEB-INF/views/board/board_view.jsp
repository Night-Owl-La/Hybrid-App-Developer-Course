<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/style.css"
	type="text/css">
<script language="JavaScript">
	function del() {
		if (confirm("삭제 하시겠습니까?")) {

			document.f.action = "board_del.jsp";

			document.f.submit();

		}
	}
	function modify() {

		document.f.action = "board_modify.jsp";

		document.f.submit();

	}
	function reply() {

		document.f.action = "board_reply.jsp";

		document.f.submit();

	}
</script>
</HEAD>

<BODY>
	<table width="690" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img
				src="${ pageContext.request.contextPath }/resources/img/title_04.gif"></td>
		</tr>
	</table>

	<form name="f" method="post">
		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="120" height="25" class="td_d">제목</td>
				<td class="td_d_1">${ vo.board_idx }</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성자</td>
				<td class="td_d_2">${ vo.user_name }</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성일</td>
				<td class="td_d_2">${ vo.board_regdate }</td>
			</tr>
			<tr>
				<td width="120" class="td_d_4">내용</td>
				<td class="td_d_3" width="570"
					style="word-wrap: break-word; word-break: break-all"><pre>${ vo.board_content }</pre>
				</td>
			</tr>
		</table>

		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td>
					<img src="${ pageContext.request.contextPath }/resources/img/btn_list.gif" onClick="location.href='list.do'" style="cursor: hand"> 
					<img src="${ pageContext.request.contextPath }/resources/img/btn_reply.gif" onClick="reply()" style="cursor: hand">
					 
					<!-- 수정이나 삭제 권한은 글쓴이나 관리자만 가집니다. -->
					<c:if test="${ user.idx eq vo.user_idx or user.grade eq '관리자' }">
						<img src="${ pageContext.request.contextPath }/resources/img/btn_modify.gif" onClick="modify()" style="cursor: hand"> 
						<img src='${ pageContext.request.contextPath }/resources/img/btn_delete.gif' onClick='del()' style='cursor: hand'>
					</c:if>
				</td>
			</tr>
		</table>
	</form>

	<p>
		<br>
</BODY>
</HTML>