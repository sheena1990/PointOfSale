package com.pos.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.pos.model.DiscountModel;

public class DiscountDao {
	private static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public DiscountDao() throws DaoException {
		con = DbAccess.getConnectionInstance();
	}

	public DiscountModel getDiscountDetails(String discountType) {
		try {
			if (con == null) {
				return null;
			}
			stmt = con.createStatement();
			String query = "select * from discountscheme where discount_type="
					+ (Integer.parseInt(discountType));
			rs = stmt.executeQuery(query);
			if (rs == null) {
				throw new DaoException("Invalid Discount Type");
			}
			DiscountModel discountModel = new DiscountModel();

			// Setting Values in discountModel Object

			while (rs.next()) {
				discountModel.setDiscountType(rs.getInt("discount_type"));
				discountModel.setDiscountName(rs.getString("discount_name"));
				discountModel.setEnrollmentDate(rs.getDate("enroll_date"));
				discountModel.setExpiryDate(rs.getDate("expiry_date"));
			}
			return discountModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}
	}

	public String getComplementaryItem(String itemId) {
		try {
			if (con == null) {
				return null;
			}
			stmt = con.createStatement();
			String query = "select complementary_item_id from complementaryitems where base_item_id="
					+ itemId;
			rs = stmt.executeQuery(query);
			if (rs == null) {
				throw new DaoException("Invalid id");
			}

			// Setting Values in discountModel Object
			String complementaryItemId=null;
			if (rs.next()) {
				complementaryItemId=rs.getString("complementary_item_id");
			}
			return complementaryItemId;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}

	}

	public String getBaseItem(String itemId) {
	
		try {
			if (con == null) {
				return null;
			}
			stmt = con.createStatement();
			String query = "select base_item_id from complementaryitems where complementary_item_id="
					+ itemId;
			rs = stmt.executeQuery(query);
			if (rs == null) {
				throw new DaoException("Invalid id");
			}

			// Setting Values in discountModel Object
			String baseItemId=null;
			if (rs.next()) {
				baseItemId=rs.getString("base_item_id");
			}
			return baseItemId;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}
	}

}
