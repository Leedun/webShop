package com.kosta.jsontest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;
//import java.awt.PageAttributes.OrientationRequestedType;
//import java.sql.Date;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpSession;
//import com.kosta.dto.UserVO;
//import com.kosta.util.DataUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empDetail2.do")
public class EmpDetailServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		
		String empid = request.getParameter("empid");
		
		int i_empid = 0;		
		
		if(empid!=null) {
			i_empid = Integer.parseInt(empid);			
		}
		EmpService eService = new EmpService();
		EmpVO emp =	eService.selectById(i_empid);
		
		//JSON객체 만들기
		
		JSONObject obj = new JSONObject();	// {}
		obj.put("emp_fname", emp.getFirst_name());
		obj.put("emp_lname", emp.getLast_name());
		String jsonStr = obj.toJSONString();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonStr);
		
		
		
	}	
}
