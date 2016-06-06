package com.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pos.model.LoyaltyCard;

public class LoyaltyCardDao {

	private static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public LoyaltyCardDao() throws DaoException {
		con = DbAccess.getConnectionInstance();
	}

	public LoyaltyCard getLoyaltyCardDetailes(String loyaltyCardId) {
		LoyaltyCard loyaltyCard = new LoyaltyCard();
		try {
			String query = "select* from loyaltycard where loyaltycard_id="
					+ Integer.parseInt(loyaltyCardId);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				loyaltyCard.setLoyaltyCardId(rs.getInt(1));
				loyaltyCard.setLoyaltyCardPoints(rs.getInt(2));
				loyaltyCard.setLoyaltyEnrollDate(rs.getDate(3));
				loyaltyCard.setLoyaltyExpiryDate(rs.getDate(4));
			}
			return loyaltyCard;
		} catch (SQLException sqx) {
			try {
				throw new DaoException("Invalid LoyaltyCardId ");
			} catch (DaoException e) {
				e.printStackTrace();
				return null;
			}
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}

	}

	public int updateLoyaltyPoints(String loyaltyCardId, int loyaltyPoints) {
		try {
			String query = "update loyaltycard set loyalty_Points="
					+ loyaltyPoints + " where loyaltycard_id='" + loyaltyCardId
					+ "' ";
			stmt = con.createStatement();
			int rows=stmt.executeUpdate(query);
			if(rows==0){
				return 0;
			}
		} catch (SQLException e) {
			try {
				throw new DaoException("Invalid Loyalty Card Id");
			} catch (DaoException e1) {
				e1.printStackTrace();
				
			}			
		}finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}
		return 1;
	}
}
