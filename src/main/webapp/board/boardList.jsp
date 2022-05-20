<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td {
	border: 5px solid green;
	border-collapse: collapse;
	padding: 10px;
	}
</style>

</head>
<body>
<h1>게시판 목록</h1>

<a href="boardInsert.do">게시글 작성하기</a>
<br>
<br>


<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>수정일</td>
	</tr>
	
<c:forEach items="${boardDatas}" var="board">
	<tr>		
		<td><a href="boardDetail.do?boardid=${board.bno}">${board.bno}</a></td>		<!-- a태그는 post가 안된다 --> 
		<td>${board.title}</td>
		<td>${board.content}</td>
		<td>${board.writer}</td>
		<td>${board.regdate}</td>
		<td>${board.updatedate}</td>
	</tr>
</c:forEach>
</table>

${boardDatas }
</body>
</html>