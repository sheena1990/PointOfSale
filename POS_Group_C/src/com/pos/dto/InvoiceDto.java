package com.pos.dto;

import java.util.Date;
import java.util.List;

import com.pos.model.InvoiceItem;

public class InvoiceDto {

	String invoiceId;
	List<InvoiceItemDto> invoiceItemDtoList;
	String date;
	String totalAmount;
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public List<InvoiceItemDto> getInvoiceItemDtoList() {
		return invoiceItemDtoList;
	}
	public void setInvoiceItemDtoList(List<InvoiceItemDto> invoiceItemDtoList) {
		this.invoiceItemDtoList = invoiceItemDtoList;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
