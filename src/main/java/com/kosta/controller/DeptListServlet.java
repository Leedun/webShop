package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptListServlet
 */

@WebServlet("/dept/deptlist.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptService();
		request.setAttribute("deptlist", service.selectAll());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
	}

	
}
