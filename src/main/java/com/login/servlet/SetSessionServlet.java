package com.login.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.model.User;
import com.login.util.QueryUtil;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetSessionServlet() {
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
		String UID = request.getParameter("UID");
		List<User> userDetails1 = QueryUtil.getUser(UID);
		HttpSession session = request.getSession();
		session.setAttribute("UID", userDetails1.get(0).getUID());
		session.setAttribute("Name", userDetails1.get(0).getName());
		session.setAttribute("Admin", userDetails1.get(0).getAdmin());
		response.sendRedirect("index.jsp");
	}
		
}
