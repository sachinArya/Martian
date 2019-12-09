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
		Booking booking = new Booking(list);
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
	
	@Then("^the data given in response body is equal to the data in request body$")
	public void verifyResponseBody(DataTable dt) {
		
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		Booking expectedResult = new Booking(list);
		
		JsonObject jsonObject = new JsonParser().parse(response.getBody().asString()).getAsJsonObject();
		
		Booking actualResult = new Gson().fromJson(jsonObject.get("booking"), Booking.class);
		
		Assert.assertEquals("Unable to verify first name ",
				expectedResult.getFirstname(),actualResult.getFirstname());
		
		Assert.assertEquals("Unable to verify last name ",
				expectedResult.getLastname(),actualResult.getLastname());
		
		Assert.assertEquals("Unable to verify total price ",
				expectedResult.getTotalprice(),actualResult.getTotalprice());
		
		Assert.assertEquals("Unable to verify deposit paid ",
				expectedResult.isDepositpaid(),actualResult.isDepositpaid());
		
		Assert.assertEquals("Unable to verify checkin date ",
				expectedResult.getBookingdates().getCheckin(), 
				actualResult.getBookingdates().getCheckin());
		
		Assert.assertEquals("Unable to verify checkout date ",
				expectedResult.getBookingdates().getCheckout(), 
				actualResult.getBookingdates().getCheckout());
		
		Assert.assertEquals("Unable to verify additional needs ",
				expectedResult.getAdditionalneeds(), 
				actualResult.getAdditionalneeds());
	}
	
	@Then("^Response body has bookingid field with non-null value$")
	public void verifyBookingID() {
		
		Assert.assertNotEquals("Booking id is null",response.jsonPath().getInt("bookingid"),null);
	
	}
	

}
