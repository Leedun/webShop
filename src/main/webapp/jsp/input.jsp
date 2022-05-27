<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%
/*  
//error연습을 위해 추가함
String num = "100dgdfg";
int num2 = Integer.parseInt(num);
  */

%>    
    
    
    
<html>
<head>
<title>Shop Cart</title>
</head>
<body>
	<hr>
	<h3>과일을 선택하고 수량을 입력한 후 장바구니에 담으세요.</h3>
	<hr>
<!-- 	<form action='./output.jsp'> -->
	<form action='./output2.jsp' method="post">
	<select name='prod'>
		<option value='사과'>사과(1개 800)
		<option value='한라봉'>한라봉(1개 2000)
		<option value='메론'>메론(1개 20000)
		<option value='복숭아'>복숭아(1개 6000)
	</select>
	<input type='text' name='count' size='5' value="1"/>개<br>
	<br>
	<br>
	<input type='submit' value='장바구니 담기' /></form>
	<!-- <button onclick="location.href='output2.jsp'">장바구니보기</button> -->
	<hr>

</body>
</html>
