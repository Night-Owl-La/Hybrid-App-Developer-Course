<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style media="screen">
	*{
		margin: 20px;
		padding: 0px;
	}
</style>
<script type="text/javascript">
	var idx =<%=request.getParameter("idx")%>;

	if (confirm("정말 삭제합니까?") == true) {
		location.href = "delete.do?idx=" + idx;
	} else {
		location.href = "list.do";
	}
</script>
</head>
<body>


</body>
</html>
