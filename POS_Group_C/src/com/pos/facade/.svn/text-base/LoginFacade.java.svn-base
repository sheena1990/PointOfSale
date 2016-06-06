package com.pos.facade;

import com.pos.dao.DaoException;
import com.pos.dao.LoginDao;

public class LoginFacade {
	public static boolean authenticate(String loginId, String password) {
		LoginDao ld;
		try {
			ld = new LoginDao();
			String pass = ld.getLoginDetail(loginId);
			if(pass==null){
				return false;
			}
			if(pass.equals(password)){
				return true;
			}
			return false;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	
	}
}
