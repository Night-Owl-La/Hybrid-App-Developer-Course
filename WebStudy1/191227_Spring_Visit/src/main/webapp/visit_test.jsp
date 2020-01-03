<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style type="text/css">

	header{}
	.container{
		width: 500px;
	}
	header h1{
	text-align: center;
	}
	
	section{}
	section ul{
		padding: 0px;
		width: 500px;
	}
	
	#disp{
		width: 500px;
		height: 100px;
		text-align: center;
	}
	
	.table{
		width: 500px;
	}
	.table input, .table textarea{
		width: 100%;
	}
	
	li{
		list-style: none;
		height: 20px;
		font-size: 20px;
	}
	
	li input{
		float: right;
	}
	li input:after{
		clear:both;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	var g_visit_array;
	
	function show(i) {
		$('#disp').html(g_visit_array[i].name+"<hr>"+g_visit_array[i].content);
	}
	
	function del(i) {
		var c_pwd = prompt("비밀번호:");
		if(c_pwd == '') return;
		if(g_visit_array[i].pwd != c_pwd){
			alert(g_visit_array[i].pwd + c_pwd);
			alert('비밀번호가 틀립니다');
			return;
		}
		
		$.ajax({
			url : "visit/json/delete.do",
			data : {'idx' : g_visit_array[i].idx},
			dataType : 'json',
			success: function(res_data) {
				if(res_data.result == 1) {
					alert("삭제 성공") ;
					$('#visit_list').children().remove();
					read_Visit_List('all', '');
				}
				else alert("삭제 실패");
			},
			error : function(error) {
				alert(error);
			}
		});
	}
	
	function read_Visit_List(search, search_text) {
		$.ajax({
			url : "visit/json/list.do",
			data : {
				'search' : search,
				'search_text' : search_text
			},
			dataType : 'json',
			success : function(res_data) {
				var visit_array = g_visit_array = res_data.list;
				for (var i = 0; i < visit_array.length; i++) {
					var li = "<li>"+(visit_array[i].name)
					+ "<input type='button' class='btn btn-info' value='보기' onclick='show("+ i +");' />"
					+ "<input type='button' class='btn btn-warning' value='삭제' onclick='del("+i+");' />"
					+"<li>";
					$('#visit_list').append(li);
				}
			},
			error : function(error) {
				alert(error);
			}

		});
	}

	$(function() {
		read_Visit_List('all', '');

	});
	
	function send() {
		$.ajax({
			url : "visit/json/insert.do",
			data : {
				"name" : $('#name').val(),
				"content" : $('#content').val(),
				"pwd" : $('#pwd').val()
			},
			dataType : 'json',
			success : function(res_data) {
				if(res_data.result == 1) {
					alert("삽입 성공");
					$('#visit_list').children().remove();
					read_Visit_List('all', '');
				}
				else alert("삽입 실패");
			},
			error : function(error) {
				alert(error);
			}
		});
	}
</script>
</head>
<body>

	<header>
		<div class="container">
			<hr />
			<h1>방명록 목록</h1>
		</div>
	</header>
	
	<section>
		<div class="container">
			<div class="wrap">
				<hr />
				<ul id="visit_list" class=""></ul>
				<hr />
				<div id="disp" class="alert-success"></div>
				<table class="table table-bordered talbe-hover alert-primary">
					<caption style="caption-side: top; text-align: center;" class="alert-info"><h2>등록하기 ▼</h2></caption>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" /></td>
					</tr>
		
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="40" id="content"></textarea></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="pwd" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" class="btn btn-primary" value="글쓰기" onclick="send();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</section>


</body>
</html>