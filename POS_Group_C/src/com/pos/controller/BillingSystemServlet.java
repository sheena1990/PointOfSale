package com.pos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pos.dao.DaoException;
import com.pos.dto.DiscountListDto;
import com.pos.dto.InvoiceDto;
import com.pos.facade.BillingFacade;
import com.pos.model.DiscountListModel;

/**
 * Servlet implementation class BillingSystemServlet
 */
@WebServlet("/BillingSystemServlet")
public class BillingSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillingSystemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DaoException {

		HttpSession session=request.getSession();
		List<DiscountListDto> discountedItemDtoList = (List<DiscountListDto>) session
				.getAttribute("discountedItemDtoList");

		// Sending List of Discounted Items into BillingFacade and calculate amount after discount
		
		BillingFacade billingFacade = new BillingFacade();
		/*List<DiscountListDto> amountList = billingFacade
				.calculateAmountAfterDiscount(discountedItemDtoList);*/
		
		// TO DO: get loyalty points from POS
		// calculating amount after loyalty points redemption and applying VAT if any
		
		String loyaltyPoints=(String) session.getAttribute("loyaltyPointsToBeRedeemed");		
		//Create an Invoice 
		InvoiceDto invoiceDto=billingFacade.createInvoice(discountedItemDtoList,loyaltyPoints);
		//session.setAttribute("loyaltyPointsAfterPurchase", amountAfterVAT);
		request.setAttribute("InvoiceDto", invoiceDto);
		request.getRequestDispatcher("Invoice.jsp").forward(request, response);
		//Award loyalty points against the amount expend.
		

		
		
	}

}
