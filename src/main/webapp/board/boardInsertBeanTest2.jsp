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
<h1>JavaBeans Test</h1>
<%
//1. 자바코드로 파라메터 받아서 객체생성
//request.setCharacterEncoding("utf-8");	//post일 때만 필요
String title = request.getParameter("title");
String content= request.getParameter("content");
String writer = request.getParameter("writer");
int i_writer = Integer.parseInt(writer);
BoardVO board = new BoardVO();
board.setTitle(title);
board.setContent(content);
board.setWriter(i_writer);


%>

제목: <%=board.getTitle() %><br>
내용: <%=board.getContent() %><br>
작성자: <%=board.getWriter() %>
<hr>
<h2>2. Action Tag사용하기 : jsp:useBean 이용</h2>
<!-- application, session, request, page의 범위를 가질 수 있다. default는 page이다.  -->
<jsp:useBean id="board2" class="com.kosta.dto.BoardVO" scope="session"></jsp:useBean>
<%-- 
<jsp:setProperty property="title" name="board2" value="${param.title}"/>
<jsp:setProperty property="content" name="board2" value="${param.content}"/>
<jsp:setProperty property="writer" name="board2" value="${param.writer}"/>
 --%>
<%--  
<jsp:setProperty property="title" name="board2" param="title"/>
<jsp:setProperty property="content" name="board2" param="content"/>
<jsp:setProperty property="writer" name="board2" param="writer"/>
 --%>
 
<%--  
 <!-- 파라메터이름(input tag의 name)과 속성이름이(VO의 변수이름) 같은 경우 생력가능  --> 
<jsp:setProperty property="title" name="board2" />
<jsp:setProperty property="content" name="board2" />
<jsp:setProperty property="writer" name="board2" />
 --%>
 
<jsp:setProperty property="*" name="board2" />
 
 
 
 
<hr>
<h2>2. Action Tag사용해서 읽기</h2>
제목: <jsp:getProperty property="title" name="board2"/><br>
내용: <jsp:getProperty property="content" name="board2"/><br>
작성자: <jsp:getProperty property="writer" name="board2"/><br>

<a href="boardInsertBeanTest3.jsp">3번째 페이지로 이동 </a>

</body>
</html>