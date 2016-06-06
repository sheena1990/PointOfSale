package com.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	private Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public LoginDao() throws DaoException {
		 con = DbAccess.getConnectionInstance();			
	}
	
	public String getLoginDetail(String loginId) {
		
		try {
			if(con==null){
				System.out.println("This is wrong3");
			}
			stmt = con.createStatement();
			String query = "select password from salesman where login_id='"
					+ loginId + "'";
			rs = stmt.executeQuery(query);
			String password = null;
			if (rs.next()){
				password = rs.getString(1);
			}
			return password;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
