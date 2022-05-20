package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		
		int i_empid = 0;
		System.out.println("empid= "+empid);
		
		
		if(empid!=null) {
			i_empid = Integer.parseInt(empid);			
		}
		EmpService eService = new EmpService();
		EmpVO emp =	eService.selectById(i_empid);
		request.setAttribute("emp", emp);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

}
