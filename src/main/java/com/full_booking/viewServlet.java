package com.full_booking;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		System.out.println(userID);
		try {
			List<CustomerBooking> cusDetails = full_bookingDBUtil.validate(userID);
			request.setAttribute("cusDetails", cusDetails);
			//Navigate page
			RequestDispatcher dis = request.getRequestDispatcher("bookingView.jsp");
			dis.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}