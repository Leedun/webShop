<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/common.css">
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table, td {
	border: 5px solid green;
	border-collapse: collapse;
	padding: 10px;
	}
	
tr:nth-child(odd){
	background-color: lightgray;
}
	
tr:nth-child(even){
	background-color: white;
}
tr:first-child{
	background-color: green;
}
	/* 
.color1 {background-color: lightgray;}
.color2 {background-color: white;} 
*/

/* 
h1 {text-align: center; padding: 20px; margin: 10px;}
 */
 
 
</style>

</head>
<body>
<h1>부서목록</h1>
<a href="deptInsert.do">신규 부서 등록</a>
<br>
<br>

<br>
<br>
<table>
	<tr>
		<td>순서</td>
		<td>부서번호</td>
		<td>부서이름</td>
		<td>메니저</td>
		<td>지역번호</td>
		<td></td>
	</tr>
	
	
<c:forEach items="${deptlist}" var="dept" varStatus="rowStatus">
	<tr>
<%-- 	<tr class="${rowStatus.count%2==0?'color1':'color2'}"> --%>
		<td>${rowStatus.count%2==0?'짝수':'홀수'}</td>
		<td><a href="../html/dept.do?dept_id=${dept.department_id}">${dept.department_id}</a></td>
		<td><a href="../html/dept.do?dept_id=${dept.department_id}">${dept.department_name}</a></td>		
		<td>${dept.manager_id}</td>
		<td>${dept.location_id}</td>
		<%-- <td><button class="btnDel btnDel-primary" data-deptid="${dept.department_id}">삭제하기</button></td> --%>
		<td><button class="btnDel" data-deptid="${dept.department_id}">삭제하기</button></td>
	</tr>

</c:forEach>


</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btnDel").on("click",f);
});

function f(){
	var deptid =  $(this).attr("data-deptid");
	location.href = "deptDelete.do?deptid="+deptid;
}

</script>

</body>
</html>