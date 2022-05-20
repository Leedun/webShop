<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인에 성공</h1>
<h2>DB접속후 다시 수정하기</h2>
<h2><%=request.getParameter("userid") %></h2>
<h2>${param.userid}</h2>
</body>
</html>