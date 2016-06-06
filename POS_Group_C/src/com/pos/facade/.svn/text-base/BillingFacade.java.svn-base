package com.pos.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
	private double sumTotal = 0; // amount after adding up all discounted prices
	double totalAmount=0; // final amount to be paid

	public double getSumTotal() {
		return sumTotal;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setSumTotal(double sumTotal) {
		this.sumTotal = sumTotal;
	}

	public List<DiscountListModel> calculateAmountAfterDiscount(
			List<DiscountListDto> discountedItemListDto) {
		List<DiscountListDto> discountedListDtoItems = new ArrayList<DiscountListDto>();
		List<DiscountListModel> discountedListItems = new ArrayList<DiscountListModel>();
		

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
			/*DiscountListDto discountTempListDto = discountListFacade
					.createDiscountListDto(discountListModel);
			discountedListDtoItems.add(discountTempListDto);*/
		}
		this.setSumTotal(sumTotal);
		return discountedListItems;
	}

	public double calculateAmountAfterRedemption(double loyaltyPoints) {
		// TODO Auto-generated method stub
		double amountAfterRedemption = getSumTotal() - loyaltyPoints;
		return amountAfterRedemption;
	}

	public double calculateTotalAmount(String loyaltyPoints) {
		double loyalty = 0;
		if (loyaltyPoints != null) {
			loyalty = (Integer.parseInt(loyaltyPoints));
		}
		double amountAfterRedemption = calculateAmountAfterRedemption(loyalty);
		int vat = 12;
		totalAmount = amountAfterRedemption
				+ (amountAfterRedemption * vat * 0.01);
		this.setTotalAmount(totalAmount);
		return totalAmount;
	}

	// creating the invoice for displaying and printing

	public InvoiceDto createInvoice(List<DiscountListDto> discountedItemDtoList, String loyaltyPoints)
			throws DaoException {

		List<DiscountListModel> discountedListItems=calculateAmountAfterDiscount(discountedItemDtoList);
		calculateTotalAmount(loyaltyPoints);	

		List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();

		InvoiceDao invoiceDao = new InvoiceDao();
		Invoice invoice = new Invoice();

		Date date = Calendar.getInstance().getTime();

		for (DiscountListModel discountListModel : discountedListItems) {
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setName(discountListModel.getItemModel().getItemName());
			invoiceItem.setPrice(discountListModel.getItemModel()
					.getUnitPrice());
			invoiceItem.setDiscountPercent(discountListModel
					.getDiscountPercent());
			invoiceItem.setAmount(discountListModel.getAmount());
			invoiceItemList.add(invoiceItem);
		}

		// Setting Values into Invoice

		invoice.setInvoiceId(0);
		invoice.setInvoiceItemList(invoiceItemList);
		invoice.setDate(date);
		invoice.setTotalAmount(totalAmount);

		/*
		 * * adding invoice to database retrieving invoiceId from database and
		 * setting into the Invoice
		 */

		int invoiceId = invoiceDao.addInvoiceToDatabase(invoice);
		invoice.setInvoiceId(invoiceId);

		// saving association to database
		// Creating ItemId list and invoiceId for associationDao

		List<String> itemIdList = new ArrayList<String>();
		for (DiscountListModel discountListModel : discountedListItems) {
			String itemId = discountListModel.getItemModel().getItemId();
			itemIdList.add(itemId);
		}

		/*
		 * * Creating Corresponding Association in Database
		 */

		AssociationDao associationDao = new AssociationDao();
		associationDao.createAssociation(itemIdList, invoiceId);
		InvoiceDto invoiceDto = createInvoiceDto(invoice);
		return invoiceDto;
	}

	private InvoiceDto createInvoiceDto(Invoice invoice) {

		InvoiceDto invoiceDto = new InvoiceDto();
		List<InvoiceItemDto> invoiceItemDtoList = new ArrayList<InvoiceItemDto>();
		invoiceDto.setInvoiceId(invoice.getInvoiceId() + "");
		invoiceDto.setDate(invoice.getDate() + "");
		invoiceDto.setTotalAmount(invoice.getTotalAmount() + "");

		for (InvoiceItem invoiceItem : invoice.getInvoiceItemList()) {
			InvoiceItemDto invoiceItemDto = new InvoiceItemDto();
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
