<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
<pre>
1. 숫자	: ${100+200}
2. 문자	: ${"Hello"}${"~~JSP"}
3. boolean : ${10>20 }
4. 문자+숫자 : ${"100"+200 }
5. 연산 : ${10/3 }
5. 연산 : ${10%3 }
<%-- 
5. 연산 : ${10 div 3 }
5. 연산 : ${10 mod 3 }
 --%> 
6. 같은지? : ${"hello" == 'hello' }
6. 같은지? : ${"hello" eq 'hello' }
6. 같은지? : ${"hello" != 'hello' }
<%-- 6. 같은지? : ${"hello" ne 'hello' } --%>
7. 비교 : ${20>= 10 }
7. 비교 : ${20 le 10 }

8. 비교, not : ${user == null }
8. 비교, not : ${user != null }
8. 비교, not : ${user }
8. 비교, not : ${user.user_id }
8. 비교, not : ${!(user.user_id=="leedun") }

9. empty : ${empty user }
9. empty : ${empty null }
9. empty : ${empty "" }




</pre>

<form action="elTest2.jsp">
myName : <input type="text" name="myName" value="AA"><br>
subject : <input type="checkbox"     value="컴공" checked="checked">컴공
subject : <input type="checkbox"     value="경재" checked="checked">경제
<br>
<input type="submit" value="ELTest2로가기">

</form>






</body>
</html>