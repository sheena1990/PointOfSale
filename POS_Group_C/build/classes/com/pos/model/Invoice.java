package com.pos.model;

import java.util.Date;
import java.util.List;

//Invoice to be printed while purchasing
public class Invoice {
	int invoiceId;
	List<InvoiceItem> invoiceItemList;
	Date date;
	double totalAmount;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public List<InvoiceItem> getInvoiceItemList() {
		return invoiceItemList;
	}

	public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
		this.invoiceItemList = invoiceItemList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
