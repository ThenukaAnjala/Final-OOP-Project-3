package com.full_booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.BookingService;
import com.oop.service.PaymentService;


@WebServlet("/full_bookingservlet")
public class full_bookingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//insert data
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//catch data
		String tripType = request.getParameter("tripType");
		String pickupDate = request.getParameter("pickupDate");
		String returnDate = request.getParameter("returnDate");
		String pickupPoint = request.getParameter("pickupPoint");
		String returnPoint = request.getParameter("returnPoint");
		String vehicleID = request.getParameter("vehicleID");
		String UID = request.getParameter("userID");
		
		boolean isTrue;
		boolean isTrue2;
		
		isTrue = full_bookingDBUtil.insertfull_booking(tripType, pickupDate, returnDate, pickupPoint, returnPoint, vehicleID, UID);
		
		if(isTrue == true) {
			isTrue2 = BookingService.addBooking(UID, vehicleID);
			
			if(isTrue2 == true) {
				RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
				dis.forward(request, response);
			}
			else
			{
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
	
}
