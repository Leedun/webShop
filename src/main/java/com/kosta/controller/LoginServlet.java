package com.kosta.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;
import com.kosta.model.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("loginForm.html"); 
		rd.forward(request, response); 		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 한글깨짐없음
		//post요청은 요청문서의 body에 파라메터가 인코딩안되어 넘어온다. 한글깨짐
		request.setCharacterEncoding("utf-8"); //post에서만 필요
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		
		UserService service = new UserService();
		UserVO user = service.selectById(id, pass);	
		
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		
		
		if(user == null) {
			//로그인 실패시 다시 로그인하도록 유도한다.
			response.sendRedirect("login.do");
		}else {
			response.sendRedirect("../emp/emplist.do");
		}
		
		
	/*	
		String email = request.getParameter("user_email");
		String address = request.getParameter("user_address");
	
		System.out.println(id);
		System.out.println(pass);
		System.out.println(email);
		System.out.println(address);
		System.out.println(request.getMethod());//get���� post���� 
		System.out.println(request.getContextPath()); 
		*/
		/*
		  msc1	
		  //���乮���� Ÿ�԰� ���ڵ� ����� ���乮������� ���� setting�Ѵ�.
		  response.setContentType("text/html;charset=utf-8"); //���乮�� ����� PrintWriter
		  out = response.getWriter(); out.write("<h1>�α��ο� ����</h1>");
		  out.write("<h2>DB������ �ٽ� �����ϱ�</h2>");		 
		 */
		
		//Servlet�� �������� JSP�� �����Ѵ�. �ּ�â�� ��������ʴ´�.
		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("../jsp/loginResult.jsp"); rd.forward(request,
		 * response); //forward �ѱ��
		 */	
		}
}
