package com.login.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.util.QueryUtil;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String NIC = request.getParameter("NIC");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");

		boolean Exist = QueryUtil.CheckUser(email);

		// Checking if the entered email already has an account
		if (Exist) {
			request.setAttribute("status", "userExist");
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		} else { // executing insert query and other server side if it is a new user
			if (QueryUtil.insertUser(name, email, NIC, password, telephone)) {
				request.setAttribute("status", "successRegister");
				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
				dis.forward(request, response);
			} else {
				request.setAttribute("status", "failedRegister");
				RequestDispatcher dis = request.getRequestDispatcher("registration.jsp");
				dis.forward(request, response);
			}
		}
	}
	
}
