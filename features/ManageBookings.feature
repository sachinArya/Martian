Feature: User is able to manage booking operations like creation, updation, deletion and retrieve

	@TestSuite
	@CreateBooking
  Scenario: Creation of a new booking
    Given user has access to perform booking for stay to meet martians
    When user provides his details for booking
			    | Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
    Then response is returned with status code 200
		And the data given in response body is equal to the data in request body
			    | Detail				  |	Value 		|
	    		| firstname  		  |Jim				| 
	    		| lastname 			  |Brown			|
	    		|	totalprice		  |111				|
	    		| depositpaid		  |true				|
	    		| checkin				  |2018-01-01	|
	    		| checkout				|2019-01-01	|
	    		| additionalneeds |Breakfast	|
		And Response body has bookingid field with non-null value
		
	@TestSuite	
	@GetBooking
	Scenario: Getting a booking by id
    Given user has created a new booking for stay to meet martians with details
    			| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
    When user tries to get booking details using his booking id
    Then response is returned with status code 200 for get booking api
		And the data given in response body is equal to the data in request body for get booking api
   				| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
      
	@TestSuite
	@UpdateBooking
	Scenario: Amendment of the created booking
		Given user is able to authenticate and tokenid using credentials
					| Detail				  |	Value 		|
					|username					|	admin			|
					|password					|password123|
    Given user has created a new booking for stay to meet martians with details for updation
    			| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
    When user provides his ammended details
    			| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Lunch			|
    Then response is returned with status code 200 for update booking api
		And the data given in response body is equal to the data in request body for update booking api
					| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Lunch			|
			    
  @TestSuite    
	@DeleteBooking
	Scenario: Delete existing booking
		Given user is able to authenticate and tokenid using credentials to call deletion api
					| Detail				  |	Value 		|
					|username					|	admin			|
					|password					|password123|
    Given user has created a new booking for stay to meet martians with details for deletion
    			| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
    When user deletes the existing booking
    Then response is returned with status code 201 for delete booking api
	  And  triggering get api for the deleted booking gives 404 status code
   
   
   
   
   
   