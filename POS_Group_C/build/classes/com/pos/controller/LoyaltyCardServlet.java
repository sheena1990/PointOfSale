package com.pos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.facade.LoyaltyCardFacade;

/**
 * Servlet implementation class LoyaltyCardServlet
 */
@WebServlet("/LoyaltyCardServlet")
public class LoyaltyCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoyaltyCardServlet() {
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

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if (op != null) {
			LoyaltyCardFacade loyaltyCardFacade = new LoyaltyCardFacade();
			String loyaltyCardId = request.getParameter("loyaltyCardId");
			String loyaltyPoints = request.getParameter("loyaltyPoints");
			
			/*
			 * Vlidate Loyalty Card
			 */
			boolean loyaltyCardValidityStatus = loyaltyCardFacade
					.verifyLoyaltyCard(loyaltyCardId);
			
			/*
			 * Update redeemed points in Database if Loyalty Card is valid
			 * Points are valid and it has enough points to be redeemed
			 */
			
			
			if (loyaltyCardValidityStatus) {
				int loyaltyPointsToBeRedeemed = loyaltyCardFacade
						.updateLoyaltyPoints(loyaltyCardId, loyaltyPoints);
				String msg = null;
				if (loyaltyPointsToBeRedeemed == -1) {
					msg = "InvalidId or Invalid entry for Loyalty Points";
				} else if (loyaltyPointsToBeRedeemed == 0) {
					msg = "Not Enough Loyalty Points";
				} else if (loyaltyPointsToBeRedeemed > 0) {
					msg = "Loyalty Points Redeemed Successfully";
					request.setAttribute("msg", msg);
					request.setAttribute("loyaltyPointsToBeRedeemed",
							loyaltyPointsToBeRedeemed);
					request.getRequestDispatcher("POSServlet").forward(request,
							response);
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("LoyalCard.jsp").forward(request,
						response);
			} else {
				request.setAttribute("msg", "Invalid LoyaltyCard Id");
				request.getRequestDispatcher("LoayltyCard.jsp").forward(
						request, response);
			}
		}
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

}
