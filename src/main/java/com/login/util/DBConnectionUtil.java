package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionUtil extends CommonUtil{
	
	public static Connection connection;
	

	public DBConnectionUtil() {
		// TODO Auto-generated constructor stub
	}
	

		
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		//Create Database Connection
		
		if(connection == null || connection.isClosed()) {
			Class.forName(properties.getProperty("driverName"));
			
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("un"), properties.getProperty("pw"));
		}
		
		return connection;
	}
}

