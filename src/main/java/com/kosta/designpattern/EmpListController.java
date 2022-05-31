package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;
import com.kosta.model.EmpService;

public class EmpListController implements Command
{
	@Override
	public String execute(HttpServletRequest request)
	{
		EmpService service = new EmpService();
		request.setAttribute("emplist", service.selectAll());
		
		return "empList.jsp";
	}
}
