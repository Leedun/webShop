<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
.right{float: right; padding-right: 20px; }
</style>    

 <div>
		<span class="right">
			<c:if test="${user !=null}">
				${user.user_name}님 환영			
				<br>
				<a class="right" href="../logOut">로그아웃</a>
			</c:if>
			<c:if test="${user ==null}">
				Guest님 환영			
			</c:if>
		</span>  
		<span>
			<!-- <a class="right" href="../logOut">로그아웃</a> -->
		</span>	
</div>   
    
