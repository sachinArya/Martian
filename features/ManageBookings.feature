Feature: User is able to manage booking operations like creation, updation, deletion and retrieve

	@Create
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
    When user provides his details for ammending his booking 
    		 	| Detail				  |	Value 		|
			    | firstname  		  |Jim				| 
			    | lastname 			  |Brown			|
			    |	totalprice		  |111				|
			    | depositpaid		  |true				|
			    | checkin				  |2018-01-01	|
			    | checkout				|2019-01-01	|
			    | additionalneeds |Breakfast	|
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
      

#	Scenario Outline: Amendment of the created booking
#    Given user has created a new booking for stay to meet martians with details
#     	| 	firstname  	| lastname | totalprice  	| depositpaid | 	checkin 	| 	checkout 		| additionalneeds |	statusCode|
#      | 	Jim 				|   Brown  | 		111				|	true				|	2018-01-01	|		2019-01-01	|	Breakfast				| 200				|
#    When user provides his ammended details first name - <firstname>, last name - <lastname>, checkin - <checkin>, checkout - <checkout>
#    And total price - <totalprice>, deposit paid - <depositpaid>, additional needs - <additionalneeds>
#    Then response is returned with status code <statusCode>
#		And the data given in response body is equal to the data in request body
#    Examples: 
     
      

   
   
   
   
   
   