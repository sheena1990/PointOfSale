package com.pos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pos.model.Invoice;
import com.pos.model.InvoiceModel;
import com.pos.model.ItemModel;

public class InvoiceDao {
	private static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public InvoiceDao() throws DaoException {
		con = DbAccess.getConnectionInstance();
	}



	public int addInvoiceToDatabase(Invoice invoice) {
		int invoiceId = 0;

		try {
			java.util.Date invoiceDate = invoice.getDate();
			stmt = con.createStatement();
			String query = "insert into invoice values('"
					+ invoice.getInvoiceId() + "','" + invoice.getTotalAmount()
					+ "','" + invoiceDate;
			int rows = stmt.executeUpdate(query);
			if (rows == 0) {
				throw new SQLException("Invalid Retrieval of Invoice");
			}
			String retrieveQuery = "Select invoice_id from invoice where date = "
					+ invoiceDate;
			rs = stmt.executeQuery(retrieveQuery);
			if (rs.next()) {
				invoiceId = rs.getInt("invoice_id");
			}
			return invoiceId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}
	}
}
