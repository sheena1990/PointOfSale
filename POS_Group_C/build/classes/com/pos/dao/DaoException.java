package com.pos.dao;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public DaoException() {
		super();
		
	}

	
	/**
	 * @param arg0
	 */
	public DaoException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public DaoException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}
 
}
