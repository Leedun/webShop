<%@page import="com.kosta.dto.BoardVO"%>
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
String menu = "아메리카노";
BoardVO board =new BoardVO(100, "목요일", "시원합니다.", 101, null, null);
session.setAttribute("menuSession", menu);
session.setAttribute("boardSession", board);
application.setAttribute("menuApp", menu);
application.setAttribute("boardApp", board);
request.setAttribute("menuReq", menu);
request.setAttribute("boardReq", board);

%>


<p>menuApp : ${menuApp }</p>
<p>boardApp : ${boardApp }</p>
<p>menuSession : ${menuSession }</p>
<p>boardSession : ${boardSession }</p>
<p>menuReq : ${menuReq }</p>
<p>boardReq : ${boardReq }</p>

<a href="sessionTest2.jsp">다른페이지로 이동</a>

</body>
</html>