package com.kosta.controller2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieTest
 */
@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetCookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//쿠키를 생성해서 응답문서에 추가하고 브라우져에 내려간다.
		
		Cookie c1 = new Cookie("cookie_subject", "jspServlet");
		c1.setMaxAge(60*3); //3분후 지워진다.
		
		Cookie c2 = new Cookie("cookie_score", "99");
		c2.setMaxAge(60*60); //1시간후 지워진다.
		
	
		Cookie c3 = new Cookie("cookie_title", URLEncoder.encode("webShop 프로젝트연습", "utf-8"));
		//c3.setMaxAge(60*60*24); //24시간후 지워진다.
		//설정안하면 유효기간이 없다
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>Served at: cookie 저장예제</h1>");		
		
	}
}
