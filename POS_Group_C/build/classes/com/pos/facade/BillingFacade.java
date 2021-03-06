package com.pos.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pos.dao.AssociationDao;
import com.pos.dao.DaoException;
import com.pos.dao.InvoiceDao;
import com.pos.dto.DiscountListDto;
import com.pos.dto.InvoiceDto;
import com.pos.dto.InvoiceItemDto;
import com.pos.model.DiscountListModel;
import com.pos.model.Invoice;
import com.pos.model.InvoiceItem;
import com.pos.model.InvoiceModel;

public class BillingFacade {
	private double sumTotal; // amount after adding up all discounted prices
	double totalAmount; // final amount to be paid
	List<DiscountListModel> discountedListItems;

	public double getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(double sumTotal) {
		this.sumTotal = sumTotal;
	}

	public List<DiscountListDto> calculateAmountAfterDiscount(
			List<DiscountListDto> discountedItemListDto) {
		List<DiscountListDto> discountedListDtoItems = new ArrayList<DiscountListDto>();
		discountedListItems = new ArrayList<DiscountListModel>();

		// list containing final amount for every item
		for (DiscountListDto discountListDto : discountedItemListDto) {
			double amount = 0;
			DiscountListFacade discountListFacade = new DiscountListFacade();
			DiscountListModel discountListModel = discountListFacade
					.createDiscountListModel(discountListDto);
			double unitPrice = discountListModel.getItemModel().getUnitPrice();
			int discountPercent = discountListModel.getDiscountPercent();
			amount = unitPrice - (unitPrice * discountPercent * 0.01);
			discountListModel.setAmount(amount);
			sumTotal = sumTotal + amount;
			discountedListItems.add(discountListModel);
			DiscountListDto discountTempListDto = discountListFacade
					.createDiscountListDto(discountListModel);
			discountedListDtoItems.add(discountTempListDto);
		}
		this.setSumTotal(sumTotal);
		return discountedListDtoItems;
	}

	public double calculateAmountAfterRedemption(double loyaltyPoints) {
		// TODO Auto-generated method stub
		double amountAfterRedemption = getSumTotal() - loyaltyPoints;
		return amountAfterRedemption;
	}

	public double calculateTotalAmount(String loyaltyPoints) {
		double loyalty=(Double.parseDouble(loyaltyPoints));
		double amountAfterRedemption = calculateAmountAfterRedemption(loyalty);
		int vat = 12;
		totalAmount = amountAfterRedemption
				+ (amountAfterRedemption * vat * 0.01);
		return totalAmount;
	}

	// creating the invoice for displaying and printing
	public InvoiceDto createInvoice(List<DiscountListDto> discountedItemDtoList) throws DaoException {
		
		calculateAmountAfterDiscount(discountedItemDtoList);
		
		
		
		Date date = new Date();
	//	DiscountScheme discountScheme = new DiscountScheme();
		InvoiceDao invoiceDao = new InvoiceDao();
	//	List<DiscountListModel> discountList = discountScheme.getDiscountList();
		InvoiceItem invoiceItem = new InvoiceItem();
		List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
		Invoice invoice = new Invoice();

		for (DiscountListModel discountListModel : discountedListItems) {
			invoiceItem.setName(discountListModel.getItemModel().getItemName());
			invoiceItem.setPrice(discountListModel.getItemModel()
					.getUnitPrice());
			invoiceItem.setDiscountPercent(discountListModel
					.getDiscountPercent());
			invoiceItem.setAmount(discountListModel.getAmount());
			invoiceItemList.add(invoiceItem);
		}
		invoice.setInvoiceId(0);// Default value of InvoiceId
		invoice.setInvoiceItemList(invoiceItemList);
		invoice.setDate(date);
		invoice.setTotalAmount(totalAmount);

		int invoiceId = invoiceDao.addInvoiceToDatabase(invoice); // adding
																	// invoice
																	// to
																	// database
		invoice.setInvoiceId(invoiceId); // retrieving invoiceId from database
											// and setting

		// saving association to database
		// Creating ItemId list and invoiceId for associationDao
		List<String> itemIdList = new ArrayList<String>();
		for (DiscountListModel discountListModel : discountedListItems) {
			String itemId = discountListModel.getItemModel().getItemId();
			itemIdList.add(itemId);
		}
		AssociationDao associationDao = new AssociationDao();
		associationDao.createAssociation(itemIdList, invoiceId); // creating
																	// corresponding
		InvoiceDto invoiceDto = createInvoiceDto(invoice);
		return invoiceDto;// association
							// in
							// database

	}

	private InvoiceDto createInvoiceDto(Invoice invoice) {
				
		InvoiceDto invoiceDto = new InvoiceDto();
		InvoiceItemDto invoiceItemDto = new InvoiceItemDto();
		List<InvoiceItemDto> invoiceItemDtoList = new ArrayList<InvoiceItemDto>();

		invoiceDto.setInvoiceId(invoice.getInvoiceId() + "");
		invoiceDto.setDate(invoice.getDate() + "");
		invoiceDto.setTotalAmount(invoice.getTotalAmount() + "");

		for (InvoiceItem invoiceItem : invoice.getInvoiceItemList()) {
			invoiceItemDto.setName(invoiceItem.getName());
			invoiceItemDto.setPrice(invoiceItem.getPrice() + "");
			invoiceItemDto.setDiscountPercent(invoiceItem.getDiscountPercent()
					+ "");
			invoiceItemDto.setAmount(invoiceItem.getAmount() + "");
			invoiceItemDtoList.add(invoiceItemDto);
		}
		invoiceDto.setInvoiceItemDtoList(invoiceItemDtoList);
		return invoiceDto;
	}
}
