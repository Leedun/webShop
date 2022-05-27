<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<%
application.setAttribute("myName", "A");
session.setAttribute("myName", "B");
request.setAttribute("myName", "C");
pageContext.setAttribute("myName", "D");

//동일 변수명 우선순위 pageContext > request > session > application

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 문법 익히기</h1>
<pre>
1. 저장영역에서 읽기(page > request > session > application) : ${myName }
1. 저장영역에서 읽기(page > request > session > application) : <%=pageContext.getAttribute("myName") %>
1. 저장영역에서 읽기 : ${applicationScope.myName } 
1. 저장영역에서 읽기 : ${sessionScope.myName }
1. 저장영역에서 읽기 : ${requestScope.myName }
1. 저장영역에서 읽기 : ${pageScope.myName }
<!-- http://localhost:9090/webShop/jsp/elTest2.jsp?myName=jin&subject=aa&subject=bb -->
2. param : ${param.myName}
2. param : ${paramValues.subject[0]}
2. param : ${paramValues.subject[1]}

3. pageContext : 내장객체이용시 이용 : ${pageContext.request.contextPath}


4. 로그인한 사용자정보: ${user }
4. 로그인한 사용자정보: ${user.user_name }
<%
pageContext.setAttribute("productVO", new Product("비비빅",1000));
List<Product> plist = new ArrayList<>();
plist.add(new Product("비비빅1",1000));
plist.add(new Product("비비빅2",1200));
plist.add(new Product("비비빅3",1300));
request.setAttribute("proList", plist);

%>

5. 객체얻기 : ${productVO.name }<!--Product의 getName() 호출됨  -->
5. 객체얻기 : ${productVO.count }<!--Product의 getCount() 호출됨  -->
6. collection얻기 : ${proList[0].name}
6. collection얻기 : ${proList[0].count}
6. collection얻기 : ${proList[1].name}
6. collection얻기 : ${proList[1].count}

7. JSTL 문법
<c:forEach items="${proList }" var="pro">
	${pro.name} ..........${pro.count}
</c:forEach>

8. Map이용
<%
Map<String, Product> cart = new HashMap<>();
cart.put("A", new Product("비비빅1",10));
cart.put("B", new Product("비비빅2",20));
cart.put("C", new Product("비비빅3",30));
request.setAttribute("cartData", cart);
%>

${cartData.A.name}....${cartData.A.count}
${cartData.B.name}....${cartData.B.count}
${cartData.C.name}....${cartData.C.count}

<c:forEach items="${cartData }" var="map">
	${map.key}....${map.value.name}....${map.value.count}
</c:forEach>
</pre>







</body>
</html>