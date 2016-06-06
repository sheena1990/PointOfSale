package com.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pos.model.ItemModel;

public class ItemDao {
	private static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public  ItemDao() throws DaoException {
		con = DbAccess.getConnectionInstance();
	}

	// method returning itemModel
	public ItemModel getItem(String itemId) {
		ItemModel itemModel = new ItemModel();
		try {			
			stmt = con.createStatement();
			String query = "select * from item where item_id='" + itemId + "'";
			rs = stmt.executeQuery(query);			
			
			// Setting Values in itemModel Object
			
			if (rs.next()) {
				itemModel.setItemId(itemId);
				itemModel.setItemName(rs.getString("item_name"));
				itemModel.setUnitPrice(rs.getDouble("unit_price"));
				itemModel.setDiscountType(rs.getInt("discount_type"));				
			}
			return itemModel;
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				throw new DaoException("Invalid ItemId");
			} catch (DaoException e1) {				
				e1.printStackTrace();
				return null;
			}
			
		} 
	}

}
