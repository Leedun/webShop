package com.kosta.model;

import com.kosta.dto.UserVO;

public class UserService {
	
	UserDAO dao = new UserDAO();
	
	public UserVO selectById(String user_id, String user_pass) {
		
		return dao.selectById(user_id, user_pass);
	}
}
