package com.kosta.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptDetailServlet
 */
@WebServlet("/html/dept.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("dept_id");
		System.out.println(deptid);
		
		int idept = Integer.parseInt(deptid);
		DeptService dService = new DeptService();
		DeptDTO dept = dService.selectById(idept);
		
		if(dept!=null) {
			request.setAttribute("deptname", dept.getDepartment_name());	//request에 (변수,값) 저장 변수에 값을 저장	
			request.setAttribute("mid", dept.getManager_id());
			request.setAttribute("loc", dept.getLocation_id());			
		}
		request.setAttribute("dept", dept);
		
		/* 이런 방식보다는 jsp를 활용하길 권장한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1> 파라메터로 받은 부서번호:"+deptid+"</h1>");
		*/
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/dept/deptDetail.jsp"); 	//절대경로
		rd.forward(request, response);	//request를 jsp로 넘겨준다 
		
		
	}

}
