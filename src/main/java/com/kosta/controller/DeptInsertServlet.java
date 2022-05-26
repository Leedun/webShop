package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/deptInsert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Filter로 처리함 request.setCharacterEncoding("utf-8");
		
		int department_id =  Integer.parseInt(request.getParameter("department_id"));
		int manager_id =  Integer.parseInt(request.getParameter("manager_id"));
		int location_id =  Integer.parseInt(request.getParameter("location_id"));
		String department_name =  request.getParameter("department_name");

		DeptDTO dept = new DeptDTO(department_id, department_name, manager_id, location_id);
		DeptService service = new DeptService();
		request.setAttribute("message",service.deptInsert(dept)>0?"insert성공":"insert실패");
		
	
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");		
		rd.forward(request, response);
	}

}
