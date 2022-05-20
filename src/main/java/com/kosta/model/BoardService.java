package com.kosta.model;

import java.sql.Date;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;


public class BoardService
{
	
	BoardDAO boardDA = new BoardDAO();
	
	
	public List<BoardEmpVO> selectAllJoin()
	{
		return boardDA.selectAllJoin();
	}
									
	
	public List<BoardVO> selectAll()
	{			
		return boardDA.selectAll();
	}	
	
	public BoardVO selectById(int bno)
	{	
		return boardDA.selectById(bno);
	}
		
	public List<BoardVO> selectByWriter(int writer)
	{	
		return boardDA.selectByWriter(writer);
	}	
	
	public List<BoardVO> selectByTitle(String title)
	{	
		return boardDA.selectByTitle(title);
	}	
	
	public List<BoardVO> selectByRegDate(Date sdate, Date edate)
	{			
		return boardDA.selectByRegDate(sdate, edate);
	}
	
	
	
	
	public int boardInsert(BoardVO board)
	{
		return boardDA.boardInsert(board);
	}	
	
	public int boardUpdate(BoardVO board)
	{
		return boardDA.boardUpdate(board);
	}

	public int boardDelete(int id)
	{		
		return boardDA.boardDelete(id);
	}	
	
	
}
