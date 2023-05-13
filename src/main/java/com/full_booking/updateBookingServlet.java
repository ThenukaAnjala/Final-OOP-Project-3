package com.full_booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateBookingServlet")
public class updateBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rBookingID = request.getParameter("rBookingID");
		String tripType = request.getParameter("tripType");
		String pickupDate = request.getParameter("pickupDate");
		String returnDate = request.getParameter("returnDate"); 
		String pickupPoint = request.getParameter("pickupPoint");
		String returnPoint = request.getParameter("returnPoint");
		
		boolean isTrue;
		isTrue = full_bookingDBUtil.updateBooking(rBookingID,tripType, pickupDate, returnDate, pickupPoint, returnPoint);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
	}

}
