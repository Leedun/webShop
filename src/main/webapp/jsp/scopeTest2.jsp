<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//자바영역
//내장객체가 제공된다. : application, session, request

%>

<h1>scopeTest2.jsp 페이지 .....Servlet Scope를 test한다. (서블릿과 연결안함)</h1>
<h2>ScriptLet문법</h2>
<p>application영역의 접근 : <%=application.getAttribute("appVar") %></p>
<p>session영역의 접근 : <%=session.getAttribute("sessionVar") %></p>
<p>request영역의 접근 : <%=request.getAttribute("requestVar") %> </p>
<hr>
<h2>EL(Expression language)문법</h2>
<p>${appVar}</p>
<p>${sessionVar}</p>
<p>${requestVar}</p>
</body>
</html>