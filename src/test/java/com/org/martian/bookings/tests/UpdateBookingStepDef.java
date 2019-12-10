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

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdateBookingStepDef {
	
	private String baseURI ="https://restful-booker.herokuapp.com";
	private int bookingId=-1;
	private Response response;
	private String token;
	
	@Given("^user is able to authenticate and tokenid using credentials$")
	public void authenticate(DataTable dt) throws Exception{
		String uri = baseURI + "/auth";
		
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String userName = list.get(0).get("Value").trim();
		String password = list.get(1).get("Value").trim();
		
		String json = "{ \"username\" : \"" + userName +"\", \"password\" : \"" + password + "\"}";
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(json);
		response = request.post(uri);
		
		Assert.assertEquals("Unable to verify response code ",
				200, response.getStatusCode());
		
		token = response.jsonPath().getString("token").trim();
	}
	
	@Given("^user has created a new booking for stay to meet martians with details for updation$")
	public void creatBooking(DataTable dt) throws Exception{
		String uri = baseURI + "/Booking";
		
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Booking booking = new Booking(list);
		String json = mapper.writeValueAsString(booking);
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(json);
		response = request.post(uri);
		
		Assert.assertEquals("Unable to verify response code ",
								200, response.getStatusCode());
								
		bookingId = response.jsonPath().getInt("bookingid");
	}
	
	
	@When("^user provides his ammended details$")
	public void ammendBookingDetails(DataTable dt) throws Exception {
		
		String uri = baseURI + "/Booking/" + bookingId;
		
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Booking booking = new Booking(list);
		String json = mapper.writeValueAsString(booking);
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.header("Cookie", "token=" + token);
		request.body(json);
		response = request.put(uri);
	
	}
	
	@Then("^response is returned with status code 200 for update booking api$")
	public void verifyReponseCode() {
		Assert.assertEquals("Unable to verify response code ",
				200, response.getStatusCode());
	}
	
	@Then("^the data given in response body is equal to the data in request body for update booking api$")
	public void verifyResponseBody(DataTable dt) {
		
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		Booking expectedResult = new Booking(list);
		
		JsonObject jsonObject = new JsonParser().parse(response.getBody().asString()).getAsJsonObject();
		
		Booking actualResult = new Gson().fromJson(jsonObject, Booking.class);
		
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
	

}
