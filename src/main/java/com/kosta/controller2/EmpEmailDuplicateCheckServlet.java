package com.kosta.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpDuplicateCheckServlet
 */
@WebServlet("/emp/emailduplicateCheckBtn.do")
public class EmpEmailDuplicateCheckServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String empEmail = request.getParameter("email");

		if (empEmail == null)
			return;
		
		
		EmpService service = new EmpService();
		int count = service.selectByEmail(empEmail);

		PrintWriter out = response.getWriter();
		out.print(count);// 0이면 등록가능 1이면 등록불가

	}

}
