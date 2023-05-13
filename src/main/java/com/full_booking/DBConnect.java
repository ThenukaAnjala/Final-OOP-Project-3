package com.full_booking;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//create DB connection
	private static String url = "jdbc:mysql://localhost:3306/booking";
	private static String userName = "root";
	private static String password = "@#thE01me";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			System.out.println("Database connection is not success!!!!!");
		}
		return con;
	}
	

}
