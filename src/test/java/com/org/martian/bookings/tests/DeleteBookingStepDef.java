package com.org.martian.bookings.tests;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.org.martian.bookings.Booking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBookingStepDef {
	
	private String baseURI ="https://restful-booker.herokuapp.com";
	private int bookingId=-1;
	private Response response;
	private String token;
	
	@Given("^user is able to authenticate and tokenid using credentials to call deletion api$")
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
	
	@Given("^user has created a new booking for stay to meet martians with details for deletion$")
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
	
	@When("^user deletes the existing booking$")
	public void deleteBooking() throws Exception {
		
		String uri = baseURI + "/Booking/" + bookingId;
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.header("Cookie", "token=" + token);
		response = request.delete(uri);
	
	}
	
	@Then("^response is returned with status code 201 for delete booking api$")
	public void verifyReponseCode() {
		Assert.assertEquals("Unable to verify response code ",
				201, response.getStatusCode());
	}
	
	@Then("^triggering get api for the deleted booking gives 404 status code$")
	public void verifyBookingIsDeleted() {
		
		if(bookingId != -1)
		{
			String uri = baseURI + "/Booking/"+ bookingId;
			
			RequestSpecification request = RestAssured.given();
			request.header("Accept", "application/json");
			response = request.get(uri);
			
			Assert.assertEquals("Unable to verify response code ",
					404, response.getStatusCode());
		}
		
		else
		{
			Assert.assertEquals("Unable to verify response code ",
					404, response.getStatusCode());
		}
	}

}
