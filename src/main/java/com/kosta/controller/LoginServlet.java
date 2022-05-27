package com.kosta.controller;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 한글깨짐없음
		// post요청은 요청문서의 body에 파라메터가 인코딩안되어 넘어온다. 한글깨짐
		request.setCharacterEncoding("utf-8");// post에서만 필요
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");

		UserService service = new UserService();
		UserVO user = service.selectById(id, pass);
		// Session저장하기: 다른페이지에서 상태를 알기위해 (로그인여부 알고 처리위해)
		// 쿠키:브라우져에 정보를 저장
		// 세션은 정보는 서버에 저장, 브라우져에서 session id저장
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		String path = (String) session.getAttribute("reqPath");
		System.out.println("path=" + path);
 		if (user == null) {
			// 로그인 실패시 다시 로그인하도록 유도한다.
			response.sendRedirect("login.do");
		} else {
			//--------------------------------------
			if(path==null)
				path = request.getContextPath() + "/index.jsp";
			//--------------------------------------
			response.sendRedirect(path);
		}

		/*
		 * String email = request.getParameter("user_email"); String address =
		 * request.getParameter("user_address"); System.out.println(id);
		 * System.out.println(pass); System.out.println("email=" + email);
		 * System.out.println("address=" + address);
		 * System.out.println(request.getMethod());
		 * System.out.println(request.getContextPath());
		 */

		/*
		 * //응답문서의 타입과 인코딩 방식을 응답문서만들기전에 setting한다.
		 * response.setContentType("text/html;charset=utf-8"); //응답문서만들기 PrintWriter out
		 * = response.getWriter(); out.write("<h1>로그인에 성공</h1>");
		 * out.write("<h2>DB접속후 다시 수정하기</h2>");
		 */
		// Servlet이 실행결과를 JSP에 위임한다. 주소창은 변경되지않는다.
		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("../jsp/loginResult.jsp"); rd.forward(request,
		 * response);
		 */
	}

}
