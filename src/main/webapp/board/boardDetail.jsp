<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Board 상세내역</h1>

<form action="boardUpdate.do" method="post">
bno:  ${board.bno} <input type="hidden" name="bno" value="${board.bno}"><br>
title: <input type="text" name="title" value="${board.title}"><br>
content: <input type="text" name="content" value="${board.content}"><br>
작성자: <input type="text" value="${board.writer}" disabled="disabled"><br>
작성일: <input type="text" value="${board.regdate}" disabled="disabled"><br>
수정일: <input type="text" value="${board.updatedate}" readonly="readonly"><br>
사진:  
<a href="${pageContext.request.contextPath}/download.do?fileName=${board.pic}">
<img alt="사진" width="300" height="300" src="${pageContext.request.contextPath}/uploads/${board.pic}">

</a> <br>
<input type="submit" value="수정">
<input type="reset" value="취소">
</form>

</body>
</html>