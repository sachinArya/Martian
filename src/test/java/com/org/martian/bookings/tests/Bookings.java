package com.org.martian.bookings.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonObject;
import com.org.martian.bookings.Booking;
import com.org.martian.bookings.BookingDates;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Bookings {

	public static void main(String[] args) throws Exception{
		
		RestAssured.baseURI ="https://restful-booker.herokuapp.com";
		
		//create new booking

		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      
		BookingDates bdates = new BookingDates();
		bdates.setCheckin("2018-01-01");
		bdates.setCheckout("2019-01-01");
		
		
		Booking booking = new Booking();
		booking.setFirstname("Jim");
		booking.setLastname("Brown");
		booking.setTotalprice(111);
		booking.setDepositpaid(true);
		booking.setBookingdates(bdates);
		booking.setAdditionalneeds("Breakfast");
		
		String json = mapper.writeValueAsString(booking);		
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(json);
		Response res = request.post("/booking");
		System.out.println("Status Code = " + res.getStatusCode());
		System.out.println("Response body = " + res.getBody().asString());

		int bookingid = res.jsonPath().getInt("bookingid");
		System.out.println("generated booking id = " + bookingid);
		
		
		//get bookings
		
		//RequestSpecification request1 = RestAssured.given();
		request.header("Accept", "application/json");
		Response res1 = request.get("/booking/" + bookingid);
		System.out.println("Status Code = " + res1.getStatusCode());
		System.out.println("Response body = " + res1.getBody().asString());

		//Get Auth Token
		//RequestSpecification request2 = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("username", "admin");
		jsonObj.addProperty("password", "password123");
		request.body(jsonObj.toString());
		Response res2 = request.post("/auth");
		System.out.println("Status Code = " + res2.getStatusCode());
		System.out.println("Response body = " + res2.getBody().asString());
		
		String token = res2.jsonPath().getString("token").trim();
		
		System.out.println(token);
		
		//Update Booking
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.header("Cookie", "token=" + token);
		request.body(json);
		Response res3 = request.put("/booking/" + bookingid);
		System.out.println("Status Code = " + res3.getStatusCode());
		System.out.println("Response body = " + res3.getBody().asString());
		
		//Delete Booking
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.header("Cookie", "token=" + token);
		request.body(json);
		Response res4 = request.delete("/booking/" + bookingid);
		System.out.println("Status Code = " + res4.getStatusCode());
		System.out.println("Response body = " + res4.getBody().asString());
		
		
	}

}
