<%@page import="com.kosta.dto.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.model.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<%
//Servlet에서 코드하는 것이 바람직하다.
BoardService service = new BoardService();
List<BoardVO> blist = service.selectAll();
request.setAttribute("blist", blist);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL문법</h2>
<c:forEach items="${blist}" var="board">
	<p>${board.title}</p>
</c:forEach>
<h2>ScriptLet문법</h2>
<%
for(BoardVO board:blist){
	out.write("<p>"+board.getTitle()+"</p>");
}
%>


</body>
</html>