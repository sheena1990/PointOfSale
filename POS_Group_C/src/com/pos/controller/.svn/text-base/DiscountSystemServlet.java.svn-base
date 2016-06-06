package com.pos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pos.dto.DiscountListDto;
import com.pos.dto.ItemDto;
import com.pos.facade.DiscountFacade;
import com.pos.facade.DiscountScheme;
import com.pos.model.DiscountListModel;

/**
 * Servlet implementation class DiscountSystemServlet
 */
@WebServlet("/DiscountSystemServlet")
public class DiscountSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiscountSystemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session==null){
			response.sendRedirect("Invoice.jsp");
		}
		List<ItemDto> itemDtoList = (List<ItemDto>) session
				.getAttribute("itemDtoList");
		DiscountFacade discountFacade = new DiscountFacade();
		/*
		 * List of Items with validated Discount Scheme
		 */

		itemDtoList = discountFacade.validateDiscount(itemDtoList);
		DiscountScheme discountScheme = new DiscountScheme();

		/*
		 * Find List of Discounted Items Using DiscountScheme Facade
		 */

		List<DiscountListDto> discountedItemDtoList = discountScheme
				.findDiscountPercent(itemDtoList);
		session.setAttribute("discountedItemDtoList", discountedItemDtoList);
		request.setAttribute("loyaltyStatusMsg",
				"List of Items is Processed. Now You can Process Loyalty Points if you want");
		request.getRequestDispatcher("Salesman.jsp").forward(request,
				response);
		}
}
