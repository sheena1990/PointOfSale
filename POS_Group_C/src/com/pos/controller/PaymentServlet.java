package com.pos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
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
		String paymentMode = request.getParameter("paymentMode");
		String cardNumber = request.getParameter("CardNumber");
		String cvvNumber = request.getParameter("CVVNumber");
		String pinCode = request.getParameter("pinCode");
		String expiryDate = request.getParameter("expiryDate");

		if (paymentMode.equalsIgnoreCase("cash")) {
			if (!((cardNumber.equals("")) || (cvvNumber.equals(""))
					|| (pinCode.equals("")) || (expiryDate.equals("")))) {
				request.setAttribute("msg",
						"Not allowed to fill entries in Cash Payment Mode");
			} else {
				request.setAttribute("msg", "payment done.");
			}
			request.getRequestDispatcher("CustomerPaymentDetails.jsp").forward(
					request, response);
		} else {

			if ((cardNumber.equals("")) || (cvvNumber.equals(""))
					|| (pinCode.equals("")) || (expiryDate.equals(""))) {
				request.setAttribute("msg", "Please Fill all payment Details");
				request.getRequestDispatcher("CustomerPaymentDetails.jsp")
						.forward(request, response);
			} else {
				int cvv = Integer.parseInt(cvvNumber);
				int pin = Integer.parseInt(pinCode);
				if ((cvvNumber.length() != 3) || (cvv < 100) || (cvv > 999)
						|| (pinCode.length() != 4) || (pin > 9999)) {
					request.setAttribute("msg", "Invalid Details");
					request.getRequestDispatcher("CustomerPaymentDetails.jsp")
							.forward(request, response);
				}

				//HttpSession session = request.getSession();
				request.setAttribute("msg", "Payment is Successfull");
				request.getRequestDispatcher("CustomerPaymentDetails.jsp");
				//session.invalidate();
			}
		}
	}
}
