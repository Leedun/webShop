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

<h1>scopeTest.jsp 페이지 .....Servlet Scope를 test한다.</h1>
<h2>ScriptLet문법</h2>
<p>application영역의 접근 : <%=application.getAttribute("appVar") %></p>
<p>session영역의 접근 : <%=session.getAttribute("sessionVar") %></p>
<p>request영역의 접근 : <%=request.getAttribute("requestVar") %> </p>
<hr>
<h2>EL(Expression language)문법</h2>
<p>application영역의 접근 : ${appVar}</p>
<p>session영역의 접근 :${sessionVar}</p>
<p>request영역의 접근 : ${requestVar}</p>

<h2> scope순서 :  request>session>application   </h2>
<h2>scope영역이 좁은순서로 찾는다: ${myphone }</h2>
<h2>applicationScope : ${applicationScope.myphone }</h2>
<h2>sessionScope : ${sessionScope.myphone }</h2>
<h2>requestScope : ${requestScope.myphone }</h2>



</body>
</html>