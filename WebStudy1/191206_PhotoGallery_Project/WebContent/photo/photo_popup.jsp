<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style type="text/css">
#popup_box {
	width: 300px;
	height: 420px;
	border: 2px solid black;
	position: absolute;
	background: white;
}

#pop_p_filename {
	width: 298px;
	height: 298px;
	border: 1px solid red;
}

#pop_p_subject {
	border: 1px solid green;
	min-height: 30px;
	text-align: center;
}

#pop_p_content {
	broder: 1px solid blue;
	min-height: 60px;
	text-align: center;
}


</style>
</head>
<body>
	<div id="popup_box">
		<div style="text-align: right;">
			<input type="button" class="btn btn-default" value="X" onclick="popup_close();" />
		</div>
		<div>
			<img id="pop_p_file" src="" />
		</div>
		<div id="pop_p_subject"></div>
		<div id="pop_p_content"> </div>
	</div>

</body>
</html>