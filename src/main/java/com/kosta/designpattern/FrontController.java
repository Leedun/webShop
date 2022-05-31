package com.kosta.designpattern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//System.out.println(request.getMethod()); 	//get post 구분
		//System.out.println(request.getRequestURI());  	// /webShop/emp/emplist.do
		//System.out.println(request.getContextPath());	// /webShop 	

		
		String method = request.getMethod();
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(uri);
		
		
		String page = "";
		Command command = null;
		
		
		
		if(uri.equals("/emp/emplist.do")) {
			command = new EmpListController();
		}else if(uri.equals("/emp/empInsert.do")){
			command = new EmpInsertController();			
		}else if(uri.equals("/emp/empDetail.do")){
			command = new EmpDetailController();
		}else if(uri.equals("/emp/empDelete.do")){
			command = new EmpDeleteController();			
		}
		
		page = command.execute(request);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}
 
	
	

}
