package com.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pos.model.Invoice;
import com.pos.model.InvoiceModel;
import com.pos.model.ItemModel;
import com.pos.model.RetrievedInvoice;

public class AssociationDao {
	private static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;

	public AssociationDao() throws DaoException {
		con = DbAccess.getConnectionInstance();
	}

	public void createAssociation(List<String> itemIdList, int invoiceId) {
		try {
			stmt = con.createStatement();
			for (String itemId : itemIdList) {
				String query = "Insert into association values('" + invoiceId
						+ "','" + itemId + "')";
				stmt.execute(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}
	}

	// getting invoice at a later time
	public RetrievedInvoice getInvoice(int invoiceId) throws DaoException {
		new InvoiceModel();
		List<String> itemIdList = new ArrayList<String>();
		List<ItemModel> itemModelList = new ArrayList<ItemModel>();
		ItemDao itemDao = new ItemDao();
		Invoice invoice = new Invoice();
		RetrievedInvoice retrievedInvoice = new RetrievedInvoice();

		try {
			stmt = con.createStatement();
			String query1 = "select * from invoice i inner join association a on i.invoice_id=a.invoice_id where a.invoice id="
					+ invoiceId;
			rs = stmt.executeQuery(query1);
			while (rs.next()) {
				invoice.setInvoiceId(invoiceId);
				invoice.setDate(rs.getDate("date"));
				invoice.setTotalAmount(rs.getDouble("total_amount"));
				String itemId = rs.getString("item_id");
				itemIdList.add(itemId);
			}
			for (String itemId : itemIdList) {
				ItemModel itemModel = itemDao.getItem(itemId);
				itemModelList.add(itemModel);
			}
			retrievedInvoice.setInvoiceId(invoiceId);
			retrievedInvoice.setDate(invoice.getDate());
			retrievedInvoice.setTotalAmount(invoice.getTotalAmount());
			retrievedInvoice.setItemModelList(itemModelList);

			return retrievedInvoice;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				DbAccess.closeConnection(con);
			}
		}

	}

}
