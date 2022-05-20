package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;


/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s_boardid = request.getParameter("boardid");
		
		int i_boardid = 0;				
		
		if(s_boardid!=null) {
			i_boardid = Integer.parseInt(s_boardid);			
		}
		
		BoardService bService = new BoardService();
		BoardVO board =	bService.selectById(i_boardid);
		request.setAttribute("board", board);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardDetail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s_boardid = request.getParameter("boardid");
		
		int i_boardid = 0;				
		
		if(s_boardid!=null) {
			i_boardid = Integer.parseInt(s_boardid);			
		}
		
		BoardService bService = new BoardService();
		BoardVO board =	bService.selectById(i_boardid);
		request.setAttribute("board", board);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardDetail.jsp");
		rd.forward(request, response);
	}


}
