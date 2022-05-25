package com.kosta.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosta.dto.UserVO;
import com.kosta.util.DBUtill;
import com.kosta.util.LogPreparedStatement;

public class UserDAO {
	Connection conn;
	LogPreparedStatement st;
	ResultSet rs;
	public UserVO selectById(String user_id, String user_pass) {
		UserVO user = null;
		conn = DBUtill.getConnection();
		try {
			st = new LogPreparedStatement(conn,"select user_name,phone from tbl_users where user_id=? and user_pass = ?");
			st.setString(1, user_id);
			st.setString(2, user_pass);
			System.out.println(st.toString());
			rs = st.executeQuery();
			while(rs.next()) {
				 user = new UserVO(user_id, rs.getString(1), user_pass, rs.getString(2));
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(rs, st, conn);
		}		
		return user;
	}
	
}
