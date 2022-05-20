package com.kosta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;
import com.kosta.util.DBUtill;

public class BoardDAO
{

	static final String SQL_SELECT_ALL = "SELECT * FROM TB_BOARD ORDER BY 1 DESC";
	static final String SQL_SELECT_BYID = "SELECT * FROM TB_BOARD WHERE bno = ?";
	static final String SQL_SELECT_BYWRITER = "SELECT * FROM TB_BOARD WHERE writer = ?";
	static final String SQL_SELECT_TITLE = "SELECT * FROM TB_BOARD WHERE title LIKE ?";
	static final String SQL_SELECT_BYREGDATE = "SELECT * FROM TB_BOARD WHERE regdate BETWEEN ? and ?";
	
	static final String SQL_INSERT = "INSERT INTO TB_BOARD VALUES( seq_bno.nextval, ?, ?, ?, sysdate, sysdate)";
	//static final String SQL_UPDATE = "";
	static final String SQL_UPDATE = "UPDATE TB_BOARD SET\r\n"
			+ "title = ?,\r\n"
			+ "content = ?,"
			+ "updatedate = sysdate\r\n"
			+ "WHERE bno = ?";
	static final String SQL_DELETE = "DELETE FROM TB_BOARD WHERE bno = ?";

	static final String SQL_BOARDEMP = "SELECT b.BNO , b.TITLE, b.CONTENT , e.FIRST_NAME ||' '|| e.LAST_NAME fullname \r\n"
			+ "FROM TB_BOARD b JOIN EMPLOYEES e ON (b.WRITER = e.EMPLOYEE_ID)";
	
	Connection conn;	
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

//	--3. JDBC프로그램(SELECT, INSERT, UPDATE, DELETE) : 함수이름은 자유롭게

	public List<BoardEmpVO> selectAllJoin()
	{
		
		List<BoardEmpVO> boardlist = new ArrayList<>();
		conn = DBUtill.getConnection();
		BoardEmpVO board =null;
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(SQL_BOARDEMP);

			while (rs.next())
			{
				board = new BoardEmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				boardlist.add(board);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return boardlist;
	}
	
	
	
	
	
	
	
	
	
	private BoardVO makeBoard(ResultSet rs) throws SQLException
	{
		BoardVO board = new BoardVO();
		board.setBno(rs.getInt(1));
		board.setTitle(rs.getString(2));;
		board.setContent(rs.getString(3));
		board.setWriter(rs.getInt(4));
		board.setRegdate(rs.getDate(5));
		board.setUpdatedate(rs.getDate(6));
		return board;
	}
	
	
	public List<BoardVO> selectAll()
	{
		
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		conn = DBUtill.getConnection();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);

			while (rs.next())
			{
				boardlist.add(makeBoard(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return boardlist;
	}
	
	
	public BoardVO selectById(int bno)
	{	
		BoardVO board = null;
		conn = DBUtill.getConnection();
		
		try
		{
			pst = conn.prepareStatement(SQL_SELECT_BYID);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				board = makeBoard(rs);
			}
			

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return board;
	}
	
	
	public List<BoardVO> selectByWriter(int writer)
	{		
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		BoardVO board = null;
		conn = DBUtill.getConnection();
		
		try
		{
			pst = conn.prepareStatement(SQL_SELECT_BYWRITER);
			pst.setInt(1, writer);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				board = makeBoard(rs);
				boardlist.add(board);
			}			

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return boardlist;
	}
	
	public List<BoardVO> selectByTitle(String title)
	{	
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		BoardVO board = null;
		conn = DBUtill.getConnection();
		
		try
		{
			pst = conn.prepareStatement(SQL_SELECT_TITLE);
			pst.setString(1, "%"+title+"%");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				board = makeBoard(rs);
				boardlist.add(board);
			}			

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return boardlist;	
	}
	
	public List<BoardVO> selectByRegDate(Date sdate, Date edate)
	{			
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		BoardVO board = null;
		conn = DBUtill.getConnection();
		
		try
		{
			pst = conn.prepareStatement(SQL_SELECT_TITLE);
			pst.setDate(1,sdate);
			pst.setDate(2,edate);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				board = makeBoard(rs);
				boardlist.add(board);
			}			

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		return boardlist;	
	}
	
	
	public int boardInsert(BoardVO board)
	{
		int result = 0;

		// SQL_INSERT
		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_INSERT);
			
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setInt(3, board.getWriter());				
			
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}
		return result;
	}
	
	
	public int boardUpdate(BoardVO board)
	{
		
		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setInt(3, board.getBno());
			
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}
		return result;
	}


	public int boardDelete(int bno)
	{
		int result = 0;
		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setInt(1, bno);
			result = pst.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}
		return result;		
	}
}
