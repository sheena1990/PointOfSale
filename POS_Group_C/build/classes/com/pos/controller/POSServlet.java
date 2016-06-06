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
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		String loyaltyPointsToBeRedeemed = (String) request
				.getAttribute("loyaltyPointsToBeRedeemed");
		List<DiscountListDto> discountedItemDtoList = (List<DiscountListDto>) request
				.getAttribute("discountedItemDtoList");
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

			/*
			 * List<DiscountListDto> discountDtoList = (List<DiscountListDto>)
			 * request .getAttribute("discountList");
			 * 
			 * request.setAttribute("discountDtoList", discountDtoList);
			 * request.getRequestDispatcher("BillingSystemServlet").forward(
			 * request, response);
			 * 
			 * List<DiscountListModel> amountList = (List<DiscountListModel>)
			 * request .getAttribute("amountList"); double sumTotal = (Double)
			 * request.getAttribute("sumTotal");
			 */

		} else if (op.equalsIgnoreCase("ProcessLoyality")) {
			request.getRequestDispatcher("LoyaltyCard.jsp").forward(request,
					response);
		} else if (op.equalsIgnoreCase("pay")) {

		} else if (Integer.parseInt(loyaltyPointsToBeRedeemed) > 0) {
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("LoyaltyCard.jsp").forward(
						request, response);
			}
			request.setAttribute("loyaltyPoints", loyaltyPointsToBeRedeemed);
			request.getRequestDispatcher("BillingSystemServlet").forward(
					request, response);
		} else if (discountedItemDtoList != null) {
			request.setAttribute("loyaltyStatusMsg",
					"List of Items is Processed. Now You can Process Loyalty Points if you want");
			request.getRequestDispatcher("Salesman.jsp").forward(request,
					response);
		}

	}

}
