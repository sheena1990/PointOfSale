package com.pos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.dto.DiscountListDto;
import com.pos.dto.ItemDto;
import com.pos.facade.LoginFacade;
import com.pos.model.DiscountListModel;

/**
 * Servlet implementation class POSServlet
 */
@WebServlet("/POSServlet")
public class POSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public POSServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			processRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			processRequest(request, response);
		
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		System.out.println(op);
		if (op == null) {
			return;
		}

		if (op.equalsIgnoreCase("login")) {				
			request.getRequestDispatcher("LoginServlet").forward(request,
					response);			
			
		} else if (op.equalsIgnoreCase("add")) {

			// getting itemID from salesman.jsp

			String itemId = request.getParameter("itemId");

			// validating ItemId

			if (itemId.equals("")) {
				System.out.println("In additon");
				request.setAttribute("msg", "Please Enter Item Id");
				request.getRequestDispatcher("Salesman.jsp").forward(request,
						response);
			}

			// forwarding itemId to SalesmanServlet
			else {
				request.setAttribute("itemId", itemId);
				request.getRequestDispatcher("SalesmanServlet").forward(
						request, response);
			}
		} else if (op.equalsIgnoreCase("done")) {
			System.out.println("Operation done");
			request.getRequestDispatcher("DiscountSystemServlet").forward(
					request, response);
		} else if (op.equalsIgnoreCase("ProcessLoyalty")) {
			System.out.println("Loyalty is Processed");
			request.getRequestDispatcher("LoyaltyCard.jsp").forward(request,
					response);
		} else if (op.equalsIgnoreCase("ProcessOrder")) {
			System.out.println("Order is Processed");
			//String loyaltyPointsToBeRedeemed=(String)request.getAttribute("loyaltyPointsToBeRedeemed");
			//request.setAttribute("loyaltyPointsToBeRedeemed", loyaltyPointsToBeRedeemed);
			request.getRequestDispatcher("BillingSystemServlet").forward(request, response);
		} else if (op.equalsIgnoreCase("pay")) {
			System.out.println("Payment is done");
			request.getRequestDispatcher("CustomerPaymentDetails.jsp").forward(request, response);
		} 
	}

	

}
