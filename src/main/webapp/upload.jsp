<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style2.css">
<title>Insert title here</title>

	<script type="text/javascript">
		function clearInput() {
			var el = document.getElementsByClassName('workbox');
			for(var i=0; i<el.length; i++){
				el[i].value = '';
			}
			
			var el = document.getElementsByClassName('namebox');
			for(var i=0; i<el.length; i++){
				el[i].value = '';
			}
		
			var el = document.getElementsByClassName('label');
			for(var i=0; i<el.length; i++){
				el[i].checked = false;
			}
		
			
		}
	</script>
</head>
<body>
	<header>
		<h1>할일 등록</h1>
	</header>

	<section>
		<form action="http://localhost:8080/mylist/Upload" method="POST">
		<h2>어떤일인가요?</h2>
		<input class="workbox" type="text" name="work" size="24" required>

		<h2>누가 할일인가요?</h2>
		<input class="namebox" type="text" name="name" size="20" required>
		

		<h2>우선순위를 선택하세요</h2>
		<input class = "label" type="radio" name="priority" value="1" required>1순위
		<input class = "label" type="radio" name="priority" value="2" required>2순위
		<input class = "label" type="radio" name="priority" value="3" required>3순위
		
		<div style="margin-top: 50px">
			<button type="button" onClick="history.go(-1)"style="float: left">이전</button>
			<button type="button" onClick="clearInput()"style="float: right">내용지우기</button>
			<button type="submit" style="float: right; margin-right: 10px">제출</button>
		</div>
		</form>
	</section>


</body>
</html>