<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td {
	border: 1px solid green;
	padding: 10px;
	border-collapse: collapse;
}

tr:first-child {
	background-color: green;
}
</style>
</head>
<body>
	<h1>직원목록</h1>

	<table>
		<tr>
			<td>직원번호</td>
			<td>성</td>
			<td>이름</td>
			<td>입사일</td>
			<td>급여</td>
			<td>전화번호</td>
			<td>부서</td>
			<td>커미션</td>
			<td>메니져</td>
			<td>직책</td>
			<td>이메일</td>
		</tr>

		<c:forEach items="${emplist}" var="emp">
			<tr>			
			
				<td><a href="empDetail.do?empid=${emp.employee_id }">${emp.employee_id }</a></td>
				<td>${emp.last_name }</td>
				<td>${emp.first_name }</td>
				<td>${emp.hire_date }</td>
				<td>${emp.salary }</td>
				<td>${emp.phone_number }</td>
				<td>${emp.department_id }</td>
				<td>${emp.commission_pct }</td>
				<td>${emp.manager_id }</td>
				<td>${emp.job_id }</td>
				<td>${emp.email }</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>