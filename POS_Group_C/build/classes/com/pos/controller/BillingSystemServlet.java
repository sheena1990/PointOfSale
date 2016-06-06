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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		List<DiscountListDto> discountedItemDtoList = (List<DiscountListDto>) session
				.getAttribute("discountedItemDtoList");

		// Sending List of Discounted Items into BillingFacade
		
		BillingFacade billingFacade = new BillingFacade();
		List<DiscountListDto> amountList = billingFacade
				.calculateAmountAfterDiscount(discountedItemDtoList);

		// Sending amountList and total to POSServlet
		
		/*request.setAttribute("amountList", amountList);
		double sumTotal = billingFacade.getSumTotal();
		request.setAttribute("sumTotal", sumTotal);
		request.getRequestDispatcher("POSServlet").forward(request, response);*/

		// TO DO: get loyalty points from POS
		// calculating amount after loyalty points redemption
		String loyaltyPoints=(String) request.getAttribute("loyaltyPoints");

		double amountAfterVAT=billingFacade.calculateTotalAmount(loyaltyPoints);
		InvoiceDto invoiceDto=billingFacade.createInvoice(discountedItemDtoList);
		
		//Award loyalty points against the amount expend.
		

		
		
	}

}
