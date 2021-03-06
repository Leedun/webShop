package com.kosta.controller;

//import java.awt.PageAttributes.OrientationRequestedType;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;
import com.kosta.util.DataUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
//@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		
		String empid = request.getParameter("empid");
		
		int i_empid = 0;
		//System.out.println("empid= "+empid);
		
		
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
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정하기
		//Filter로 처리함 request.setCharacterEncoding("UTF-8");
		EmpVO emp = makeEmp(request);
		EmpService eService = new EmpService();
		int result = eService.empUpdate(emp);
		request.setAttribute("message", result>0?"직원정보 수정성공":"직원정보 수정실패");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
			
		
		
	}

	private EmpVO makeEmp(HttpServletRequest request)
	{
		EmpVO emp = new EmpVO();
		int empid = readInt(request, "employee_id");
		int mid = readInt(request, "manager_id");
		int did = readInt(request, "department_id");
		double salary = readDouble(request, "salary");
		double commission_pct = readDouble(request, "commission_pct");
		Date hire_date = readDate(request, "hire_date");
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setLast_name(last_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setManager_id(mid);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}

	private int readInt(HttpServletRequest request, String column)
	{
		String data = request.getParameter(column);		
		return Integer.parseInt(data);
	}
	
	private Double readDouble(HttpServletRequest request, String column)
	{
		String data = request.getParameter(column);		
		return Double.parseDouble(data);
	}
	
	private Date readDate(HttpServletRequest request, String column)
	{
		String data = request.getParameter(column);		
		return DataUtil.convertToDate(data);
	}



	
	
	
	

}
