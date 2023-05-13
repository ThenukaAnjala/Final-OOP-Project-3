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
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UID = request.getParameter("UID");
		String Admin = request.getParameter("Admin");
		boolean status = Boolean.parseBoolean(Admin);
		int tAdmin;
		
		if(status == true ) {
			tAdmin = 0;
		} else {
			tAdmin = 1;
		}
		
		if(QueryUtil.updateAdmin(UID, tAdmin)) {
			List<User> userDetails = QueryUtil.getAllUsers();
			request.setAttribute("userDetails", userDetails);
			RequestDispatcher dis = request.getRequestDispatcher("adminPage.jsp");
			dis.forward(request, response);
		} else {
			request.setAttribute("status", "failedUpdate");
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}
		
	}

}
