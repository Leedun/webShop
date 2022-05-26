package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletScopeTest
 */
@WebServlet("/ServletScopeTest")
public class ServletScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		//1. server가 살아있는 동안(started) 모든 JSP/Servlet에서 접근가능
		ServletContext app = getServletContext();
		//2. Browser가 살아있는 동안 모든 JSP/Servlet에서 접근가능
		HttpSession sess = req.getSession();
		//3. HttpServletRequest request : 요청이 살아있는 동안(요청이 바뀌지 않는 동안) JSP/Servlet에서 접근가능
		
		app.setAttribute("appVar", "ServletContext는 server가 살아있는 동안(started) 모든 JSP/Servlet에서 접근가능");
		sess.setAttribute("sessionVar", "Browser가 살아있는 동안 모든 JSP/Servlet에서 접근가능");
		req.setAttribute("requestVar", "HttpServletRequest request : 요청이 살아있는 동안(요청이 바뀌지 않는 동안) JSP/Servlet에서 접근가능");
		
		app.setAttribute("myphone", "1");
		sess.setAttribute("myphone", "2");
		req.setAttribute("myphone", "3");
		
		//서블릿 API에 바인딩된 속성에 대한 접근 범위
		//ServletContext 속성은 애플리케이션 전체에서 접근 가능
		//HttpSession 속성은 사용자만 접근 가능
		//HttpSevletRequest 속성은 해당 요청/응답에 대해서
		//각 스코프를 이용해서 로그인 상태 유지, 장바구니, MVC의 Model과 View만 접근 가능의 데이터 전달 기능을 구현
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("jsp/scopeTest.jsp");
		rd.forward(req, response);
		
		
	}

	

}
