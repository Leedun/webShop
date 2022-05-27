<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Action Tag Test1.............</h1>

<hr>
<h2>include Directive 이용</h2>
<%@ include file="actionTagTest2.jsp" %>
<hr>
<h2>Action Tag이용</h2>
<jsp:include page="actionTagTest2.jsp"></jsp:include>


</body>
</html>