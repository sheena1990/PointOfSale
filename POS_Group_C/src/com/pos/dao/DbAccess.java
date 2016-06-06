package com.pos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private static final String DBNAME = "jdbc:MySql://localhost/possystem";

	private static Connection con;

	public static Connection getConnectionInstance() throws DaoException  {
		try {
			System.out.println("In DBAccess");
			Class.forName(DBDRIVER);
			System.out.println("After DBAccess");
			con = DriverManager.getConnection(DBNAME, DBUSER, DBPASSWORD);
			System.out.println("Connection made");
			
			return con;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			throw new DaoException("SQL Driver is not found");
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new DaoException("Connection is not instantiated");
		}
		
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {			
			e.printStackTrace();
			
		}
	}
}