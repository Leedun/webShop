<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 이것은 JSP주석입니다. JSP에서만 보인다.. .java에는 없다 .html없다. 

Derective
%@ page   
%@ include   
%@ taglib
   
   
--%>

<%
/* 자바주석 */
// 자바주석
// 자바코드가 .java의 service메서드에 들어간다.
String coffee = "아메리카노";
out.println("<h2>"+coffee +"</h2>");
%>
<%!
//멤버변수와 멤버메서드
int price = 2000;
public int getPrice(){
	return price;
}


%>




    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석 HTML문서에서 볼 수 있다.  -->
<h1><%=coffee %></h1> <%--Expression, 문장아니므로 ;를 사용하면 안된다 --%>

<%
for(int i=1; i<=5; i++){	%>
	<h3><%=i %> </h3>	
<%
}
%>






</body>
</html>