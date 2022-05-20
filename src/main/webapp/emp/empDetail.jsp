<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원의 상세내역</h1>
직원번호:${emp.employee_id} <br>
first name: ${emp.first_name} <br>
last name:${emp.last_name} <br>
email:${emp.email} <br>
phone: ${emp.phone_number} <br>
commission:${emp.commission_pct} <br>
manager_id:${emp.manager_id} <br>
department_id;${emp.department_id} <br>
job_id:${emp.job_id} <br>
입사일:${emp.hire_date} <br>
급여:${emp.salary} <br>
 
</body>
</html>