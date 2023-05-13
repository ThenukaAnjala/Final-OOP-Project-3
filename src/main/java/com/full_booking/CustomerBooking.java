package com.full_booking;


public class CustomerBooking {
	private String rBookingID;
	private String tripType;
	private String pickupDate;
	private String returnDate;
	private String pickupPoint;
	private String returnPoint;
	
	//Constructor

	public CustomerBooking(String rBookingID, String tripType, String pickupDate, String returnDate, String pickupPoint, String returnPoint) {
		//super();
		this.rBookingID = rBookingID;
		this.tripType = tripType;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.pickupPoint = pickupPoint;
		this.returnPoint = returnPoint;
	}
	//getters

	public String getrBookingID() {
		return rBookingID;
	}


	public String getTripType() {
		return tripType;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public String getReturnPoint() {
		return returnPoint;
	}

	

}
