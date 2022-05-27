<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>알림</h1>
<p><%=exception %></p>
<p><%=exception.getMessage() %></p>
<hr>
<%
	exception.printStackTrace();	
%>
<p>전산실로 연락바랍니다</p>
</body>
</html>