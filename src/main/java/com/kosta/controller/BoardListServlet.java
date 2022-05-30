package com.kosta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/boardlist.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardService service = new BoardService();
		List<BoardVO> blist = service.selectAll();
		
		request.setAttribute("boardDatas", blist);
		request.setAttribute("boardSize", blist.size());
		//위임 (요청을 받은것은 Servlet인데 응답은 JSP가 하도록한다)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/
}
