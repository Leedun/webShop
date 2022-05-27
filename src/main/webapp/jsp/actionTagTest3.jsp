<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Action Tag Test3.............</h1>

<hr>
<h2>Action Tag이용.....forward</h2>
<p>요청과 응답이 다르다. 주소창은 바뀌지 않는다. </p>
<%-- 
<jsp:forward page="input.jsp"></jsp:forward> 
--%>

<p>요청 주소창은 바뀌지 않는다. 다른페이지의 수행결과가 현재페이지 안으로 온다</p>
<jsp:include page="input.jsp"></jsp:include>


</body>
</html>