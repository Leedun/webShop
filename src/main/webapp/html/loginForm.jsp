<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인하기</h1>



<!-- 
<link rel="stylesheet" href="../css/common.css"> 
-->

<form action="login.do" method="post">
사용자번호:<input type="text" name="userid"><br>
비밀번호:<input type="text" name="userpass"><br>

<input type="hidden" name="user_email" value="zzilre@naver.com"><br>
<input type="hidden" name="user_address" value="seoul"><br>


<input type="submit" value="로그인">
</form>

</body>
</html>