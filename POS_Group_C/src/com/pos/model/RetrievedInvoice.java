package com.pos.model;

import java.util.Date;
import java.util.List;

public class RetrievedInvoice {
	int invoiceId;
	double totalAmount;
	Date date;
	List<ItemModel> itemModelList;
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ItemModel> getItemModelList() {
		return itemModelList;
	}
	public void setItemModelList(List<ItemModel> itemModelList) {
		this.itemModelList = itemModelList;
	}
	
}
