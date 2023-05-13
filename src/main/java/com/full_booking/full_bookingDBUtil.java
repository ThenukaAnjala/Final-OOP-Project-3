package com.full_booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class full_bookingDBUtil {
	//instance variables
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static boolean insertfull_booking(String tripType, String pickupDate, String returnDate, String pickupPoint, String returnPoint, String vehicleID, String UID) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into booking_table values(0,'"+vehicleID+"', '"+UID+"','"+tripType+"','"+pickupDate+"','"+returnDate+"','"+pickupPoint+"','"+returnPoint+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
				
			}else {
				isSuccess = false;
			}
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//view booking
			public static List<CustomerBooking> validate(String userID){
				ArrayList<CustomerBooking> cus = new ArrayList<>();
				
				//validate
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "select rBookingID,tripType,pickupDate,returnDate,pickupPoint,returnPoint from booking_table where userID="+userID+"";
					rs= stmt.executeQuery(sql);
					
					System.out.println("inside util " + userID + " is the game");
					if(rs.next()) {
						String rBookingID = rs.getString(1);
						String tripType = rs.getString(2);
						String pickupDate = rs.getString(3);
						String returnDate = rs.getString(4);
						String pickupPoint = rs.getString(5);
						String returnPoint = rs.getString(6);
						
						CustomerBooking c = new CustomerBooking(rBookingID,tripType,pickupDate,returnDate,pickupPoint,returnPoint);
						cus.add(c);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
			}
				return cus;
				
				
			
		}
			public static boolean updateBooking(String rBookingID,String tripType,String pickupDate, String returnDate, String pickupPoint, String returnPoint) {
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "update booking_table set tripType = '"+tripType+"', pickupDate = '"+pickupDate+"', returnDate = '"+returnDate+"', pickupPoint = '"+pickupPoint+"', returnPoint = '"+returnPoint+"'" + "where rBookingID = '"+rBookingID+"'";
					int rs = stmt.executeUpdate(sql);
					
					if(rs > 0) {
						isSuccess = true;
					}
					else {
						isSuccess = false;
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
				return isSuccess;
				
			}
			
			public static boolean cancelBooking(String rBookingID) {
				int convId = Integer.parseInt(rBookingID);
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "delete from booking_table where rBookingID = '"+convId+"'";
					int r =stmt.executeUpdate(sql);
					
					if(r > 0) {
						isSuccess =true;
						
					}
					else {
						isSuccess = false;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					
				}
				
				
					
				return isSuccess;
			}
}
