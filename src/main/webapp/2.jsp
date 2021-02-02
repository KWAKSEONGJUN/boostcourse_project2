<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style2.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>할일 등록</h1>
	</header>

	<section>
		<form action="/Upload" method="POST">
		<h2>어떤일인가요?</h2>
		<input class="workbox" type="text" name="work" size="24">

		<h2>누가 할일인가요?</h2>
		<input class="namebox" type="text" name="name" size="20">
		

		<h2>우선순위를 선택하세요</h2>
		<input type="radio" name="priority" value="1">1순위
		<input type="radio" name="priority" value="2">2순위
		<input type="radio" name="priority" value="3">3순위
		
		<div style="margin-top: 50px">
			<button type="button" onClick="history.go(-1)"style="float: left">이전</button>
			<button type="button" style="float: right">내용지우기</button>
			<button type="submit" style="float: right; margin-right: 10px">제출</button>
		</div>
		</form>
	</section>


</body>
</html>