<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp, servlet 학습하기</h1>
<h2>get 요청1</h2>
<a href="FirstServlet">firstServlet요청</a>
<h2>get 요청2</h2>
<form action="FirstServlet" method="get">
	<input type="submit" value="firstServlet">
</form>
<button id="btn1">get요청</button>
<hr>

<h2>post 요청</h2>
<form action="FirstServlet" method="post">
	<input type="submit" value="firstServlet요청(post)">
</form>
<hr>
<ul>
	<li><a href="emp/emplist.do">모든 직원정보 조회</a>
	<li><a href="dept/deptlist.do">모든 부서정보 조회</a>
	<li><a href="board/boardlist.do">모든 게시판정보 조회</a>
</ul>



<script type="text/javascript">
btn1.onclick = function(){
	location.href= "webShop/kosta/first3.do";	//절대경로
//	location.href= "kosta/first3.do";			//상대경로
}
</script>	
</body>
</html>