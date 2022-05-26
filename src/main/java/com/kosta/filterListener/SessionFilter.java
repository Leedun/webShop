package com.kosta.filterListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		/////////////Session처리/////////////////////		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();

		
		//String path = req.getContextPath() + req.getServletPath();
		String path = req.getServletPath();
		
		System.out.println("요청주소:" +path);		
		
		
		
		if(!path.equals("/html/login.do")) {
			
			UserVO user = (UserVO)session.getAttribute("user"); 
			System.out.println(user);
			
			

			
			if(user == null) {
				//절대경로가 바람직하다. 
				
				session.setAttribute("reqPath", req.getContextPath() + path);				
				System.out.println("로그인하지않음.....직원정보 볼수없음");
				resp.sendRedirect(req.getContextPath() + "/html/login.do"); //주소창바꾸기(새로운요청을 의미)
				return;			
			}	
//			if(!path.equals("/logOut") && !path.equals("/index.jsp"))
		/*	if(!path.equals("/index.jsp"))
			{
				System.out.println("req.getContextPath()"+req.getContextPath());
								
				session.setAttribute("reqPath", req.getContextPath() + path);
				System.out.println("aapath "+path);
				resp.sendRedirect(path); //주소창바꾸기(새로운요청을 의미)
				
			}
			*/
			
		}
		chain.doFilter(request, response);
	}

	 

}
