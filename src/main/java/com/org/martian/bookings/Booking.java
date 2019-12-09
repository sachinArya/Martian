package com.org.martian.bookings;

import java.util.List;
import java.util.Map;

public class Booking {

	//Object Properties
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;
	
	public Booking()
	{
		
	}
	
	public Booking(List<Map<String, String>> list)
	{
		BookingDates bdates = new BookingDates();
		bdates.setCheckin(list.get(4).get("Value").trim());
		bdates.setCheckout(list.get(5).get("Value").trim());

		this.setFirstname(list.get(0).get("Value").trim());
		this.setLastname(list.get(1).get("Value").trim());
		this.setTotalprice(Integer.parseInt(list.get(2).get("Value").trim()));
		this.setDepositpaid(Boolean.parseBoolean(list.get(3).get("Value").trim()));
		this.setBookingdates(bdates);
		this.setAdditionalneeds(list.get(6).get("Value").trim());
	}
	
	//Setters and Getters
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public BookingDates getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	

}
