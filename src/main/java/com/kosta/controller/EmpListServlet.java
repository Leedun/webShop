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
import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		if(user ==null) {
			System.out.println("로그인 하지않음..... 직원정보 볼 수 없다");
			response.sendRedirect("../html/longin.do");
			return;
		}
		
		
		
		EmpService service = new EmpService();
		request.setAttribute("emplist", service.selectAll());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}

}
