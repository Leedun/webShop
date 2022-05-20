package com.kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtill
{
	

	public static Connection getConnection()	
	{
		Connection conn = null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";		
		String userid="hr", password="hr";
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");	
			
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println(" Connection ����");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	public static void dbClose(ResultSet rs , Statement st, Connection conn)
	{
		try
		{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

