<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<title>Shop Cart</title>
</head>
<body>
	<hr>
	<h3>������ �����ϰ� ������ �Է��� �� ��ٱ��Ͽ� ��������.</h3>
	<hr>
	<form action='./output.jsp'>
	<select name='prod'>
		<option value='���'>���(1�� 800)
		<option value='�Ѷ��'>�Ѷ��(1�� 2000)
		<option value='�޷�'>�޷�(1�� 20000)
		<option value='������'>������(1�� 6000)
	</select>
	<input type='text' name='count' size='5' />��<br>
	<br>
	<br>
	<input type='submit' value='��ٱ��� ���' /></form>
	<hr>
</body>
</html>
