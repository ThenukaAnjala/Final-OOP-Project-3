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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String UID = request.getParameter("UID");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String NIC = request.getParameter("NIC");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		
		// Server side validation
		if (name == null || name == "") {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "emptyName");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (email == null || email == "") {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "emptyEmail");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (NIC == null || NIC == "") {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "emptyNIC");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (password == null || password == "") {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "emptyPassword");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (password.length() < 8) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "PassLen");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (!checkForNumber(password)) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "noNumber");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (!checkForLetter(password)) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "noLetter");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (!checkForSpecial(password)) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "noSpecial");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (telephone == null || telephone == "") {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "emptyTelephone");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (telephone.length() > 10) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "invalidTelephone");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (NIC.length() > 12) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "invalidNIC");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (checkForSpecial(telephone)) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "invalidTelephone");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		}else if (checkForLetter(telephone)) {
			List<User> userDetails = QueryUtil.getUser(UID);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "invalidTelephone");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		} else if (QueryUtil.updateUser(UID, name, email, NIC, password, telephone)) {
			List<User> userDetails = QueryUtil.getUser(email, password);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "successUpdate");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		}
		else {
			request.setAttribute("status", "failedUpdate");
			RequestDispatcher dis = request.getRequestDispatcher("UserAccountPage.jsp");
			dis.forward(request, response);
		}
	}
	
	
	// Methods Used for validation
	public boolean checkForNumber(String s) {
		boolean result = false;
		for(int i=0; i < s.length(); i++ ) {
			if(Character.isDigit(s.charAt(i))) {
				result = true;
				break;
			}
			else {
				result = false;
			}
		}
		return result;
	}
	
	public boolean checkForLetter(String s) {
		boolean result = false;
		for(int i=0; i < s.length(); i++ ) {
			if(Character.isLetter(s.charAt(i))) {
				result = true;
				break;
			}
			else {
				result = false;
			}
		}
		return result;
	}
	
	
	public boolean checkForSpecial(String s) {
		boolean result = false;
		for(int i=0; i < s.length(); i++ ) {
			if(s.charAt(i) == '*' || s.charAt(i) == '&' || s.charAt(i) == '^' || s.charAt(i) == '%' 
					|| s.charAt(i) == '$' || s.charAt(i) == '#' || s.charAt(i) == '@' || s.charAt(i) == '!')  {
				result = true;
				break;
			}
			else {
				result = false;
			}
		}
		return result;
	}

}
