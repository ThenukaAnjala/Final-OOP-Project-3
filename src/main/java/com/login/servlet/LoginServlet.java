package com.login.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.login.model.User;
import com.login.util.QueryUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		
		List<User> userDetails = QueryUtil.getUser(email, password);		
		
		if (QueryUtil.validate(email, password)) {
			if (!QueryUtil.CheckAdmin(email)) {
				request.setAttribute("userDetails", userDetails);
				request.setAttribute("status", "successLogin");
				RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
				dis.forward(request, response);
			} else {
				userDetails = QueryUtil.getAllUsers();
				request.setAttribute("userDetails", userDetails);
				RequestDispatcher dis = request.getRequestDispatcher("adminPage.jsp");
				dis.forward(request, response);
			}
		} else {
			request.setAttribute("status", "invalidUnPw");
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}

	}

}
