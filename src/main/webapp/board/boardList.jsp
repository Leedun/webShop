<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/common.css">

<style type="text/css">
table, td {
	border: 5px solid green;
	border-collapse: collapse;
	padding: 10px;
	}


/* 
h1 {text-align: center; padding: 20px; margin: 10px;}
.h1 {text-align: center; padding: 20px; margin: 10px;}
.left {float: left; padding-left: 20px;}
.right{float: right; padding-right: 20px; }	
 */

.color1 {background-color: lightgray;}
.color2 {background-color: white;}
.color3 {background-color: yellow;}
</style>

</head>
<body>
<h1>게시판 목록</h1>
<h3>
	application정보얻기 : ${myname} <br>
</h3>


<a href="boardInsert.do">게시글 작성하기</a>
<hr>


<br>
<br>


<table>
	<tr>
		<td>순서</td>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>수정일</td>
		<td></td>
	</tr>




<%-- 
방법1 : ${boardSize }<br>
방법2 : <c:set var="listSize" value="${boardDatas.size() }"> </c:set>
 --%>
<c:forEach items="${boardDatas}" var="board" varStatus="rowStatus">
	<tr  class="${rowStatus.count%2==0?'color1':'color2'}" >	
		<td>${rowStatus.count}....${listSize-rowStatus.index } </td>
		<td><a href="boardDetail.do?boardid=${board.bno}">${board.bno}</a></td>		<!-- a태그는 post가 안된다 -->		 
		<td>${board.title}</td>
		<td>${board.content}</td>
		<td>${board.writer}</td>
		<td>${board.regdate}</td>
		<td>${board.updatedate}</td>
<%-- 		<td><button class="btnDel btn-primary" data-bno="${board.bno}">삭제하기</button></td> --%>
		<td><button class="btnDel" data-bno="${board.bno}">삭제하기</button></td>
	</tr>
</c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
$(function(){
	//# : 아이디를 의미, 아이디는 문서내에세 유일하다.
	//. : 클래스를 의미
	$(".btnDel").click(function(){
		var bno = $(this).attr("data-bno");
		if(confirm(bno+ "삭제?")){
			location.href = "boardDelete.do?bno=" + bno;
		}	
	});	
});
</script>
</body>
</html>