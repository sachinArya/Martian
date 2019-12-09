package com.org.martian.bookings.tests;

import java.util.List;
import java.util.Map;
import org.junit.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.org.martian.bookings.Booking;
import com.org.martian.bookings.BookingDates;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateBookingStepDef {
	
	private String baseURI ="https://restful-booker.herokuapp.com";
	private Response response;
	
	@Given("^user has access to perform booking for stay to meet martians$")
	public void accesstoBook() {
		baseURI = baseURI + "/Booking";
	}
	
	@When("^user provides his details for booking$")
	public void adding_booking_details(DataTable dt) throws Exception {
	
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      
		BookingDates bdates = new BookingDates();
		bdates.setCheckin(list.get(4).get("Value").trim());
		bdates.setCheckout(list.get(5).get("Value").trim());
		
		
		Booking booking = new Booking();
		booking.setFirstname(list.get(0).get("Value").trim());
		booking.setLastname(list.get(1).get("Value").trim());
		booking.setTotalprice(Integer.parseInt(list.get(2).get("Value").trim()));
		booking.setDepositpaid(Boolean.parseBoolean(list.get(3).get("Value").trim()));
		booking.setBookingdates(bdates);
		booking.setAdditionalneeds(list.get(6).get("Value").trim());
		
		String json = mapper.writeValueAsString(booking);
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(json);
		response = request.post(baseURI);
		
	}
	
	@Then("^response is returned with status code 200$")
	public void verifyReponseCode() {
		Assert.assertEquals("Unable to verify response code ",
								200, response.getStatusCode());
	}
	
	@When("^the data given in response body is equal to the data in request body$")
	public void verifyResponseBody(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		JsonObject jsonObject = new JsonParser().parse(response.getBody().asString()).getAsJsonObject();

		JsonObject bookingObj = jsonObject.getAsJsonObject("booking");
		
		String fName = bookingObj.get("firstname").getAsString().trim();
		String lName = bookingObj.get("lastname").getAsString().trim();
		int totalPrice = bookingObj.get("totalprice").getAsInt();
		boolean depositpaid = bookingObj.get("depositpaid").getAsBoolean();
		String additionalNeeds = bookingObj.get("additionalneeds").getAsString().trim();;
		String checkIn = bookingObj.getAsJsonObject("bookingdates").get("checkin").getAsString().trim();
		String checkOut = bookingObj.getAsJsonObject("bookingdates").get("checkout").getAsString().trim();
		
		Assert.assertEquals("Unable to verify first name ",
				list.get(0).get("Value").trim(),fName);
		
		Assert.assertEquals("Unable to verify last name ",
				list.get(1).get("Value").trim(),lName);
		
		Assert.assertEquals("Unable to verify total price ",
				Integer.parseInt(list.get(2).get("Value").trim()),totalPrice);
		
		Assert.assertEquals("Unable to verify deposit paid ",
				Boolean.parseBoolean(list.get(3).get("Value").trim()),depositpaid);
		
		Assert.assertEquals("Unable to verify checkin date ",
				list.get(4).get("Value").trim(), checkIn);
		
		Assert.assertEquals("Unable to verify checkout date ",
				list.get(5).get("Value").trim(), checkOut);
		
		Assert.assertEquals("Unable to verify additional needs ",
				list.get(6).get("Value").trim(), additionalNeeds);
		
	}
	
	@Then("^Response body has bookingid field with non-null value$")
	public void verifyBookingID() {
		
		Assert.assertNotEquals("Booking id is null",response.jsonPath().getInt("bookingid"),null);
	
	}
	

}
