<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>
<%@page import="dao.TodoDao"%>
<%@page import="dto.TodoDto"%>

	<%
			List<TodoDto> todo = (List<TodoDto>)request.getAttribute("todo");
			List<TodoDto> doing = (List<TodoDto>)request.getAttribute("doing");
			List<TodoDto> done = (List<TodoDto>)request.getAttribute("done");
			
	%>
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>

<script type="text/javascript">

function todoType(id, type){
	
	var parm = "?id=" + id + "&type=" + type; 
	
	var url = "http://localhost:8080/mylist/TodoTypeServlet" + parm;
	 var oReq = new XMLHttpRequest();
	 oReq.addEventListener("load", function(){
			location.reload();
		}
	 )
	 oReq.open("POST", url);//parameter를 붙여서 보낼수있음. 
	 oReq.send();
}

</script>
</head>
<body>
	<header>
		<h1 class="rotate">나의 해야할 일들</h1>
		<nav class="new-upload">
		<button type="button" onClick="location.href='upload.jsp'">새로운 TODO 등록</button>
		</nav>
	</header>

	<div class="container" >
		<ul id = "todo">
			<h2 class="list">TODO</h2>
		<c:forEach items="${todo}" var="item">
			<li class="card">
				<div style="font-size:18px">
				${item.title}
				</div>
				
				<div style="font-size:12px">
				${item}
				<button type="button" onClick="todoType('${item.id}', '${item.type}')">-></button>
				</div>
			</li>
		</c:forEach>
			
		</ul>

		<ul id = "doing">
			<h2 class="list">DOING</h2>
			<c:forEach items="${doing}" var="item">
			<li class="card">
				<div style="font-size:18px">
				${item.title}
				</div>
				
				<div style="font-size:12px">
				${item}
				<button type="button" onClick="todoType('${item.id}', '${item.type}')">-></button>
				</div>
				
			</li>
		</c:forEach>
			
		</ul>

		<ul id="done">
			<h2 class="list">DONE</h2>
			<c:forEach items="${done}" var="item">
				<li class="card">
			<div style="font-size:18px">
			${item.title}
			</div>
			<div style="font-size:12px">
			${item}
			</div>
			</li>
		</c:forEach>
			
		</ul>
	</div>


</body>
</html>