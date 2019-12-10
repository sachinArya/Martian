$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features\\ManageBookings.feature");
formatter.feature({
  "name": "User is able to manage booking operations like creation, updation, deletion and retrieve",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creation of a new booking",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TestSuite"
    },
    {
      "name": "@CreateBooking"
    }
  ]
});
formatter.step({
  "name": "user has access to perform booking for stay to meet martians",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateBookingStepDef.accesstoBook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides his details for booking",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateBookingStepDef.adding_booking_details(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response is returned with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateBookingStepDef.verifyReponseCode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the data given in response body is equal to the data in request body",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateBookingStepDef.verifyResponseBody(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Response body has bookingid field with non-null value",
  "keyword": "And "
});
formatter.match({
  "location": "CreateBookingStepDef.verifyBookingID()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Getting a booking by id",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TestSuite"
    },
    {
      "name": "@GetBooking"
    }
  ]
});
formatter.step({
  "name": "user has created a new booking for stay to meet martians with details",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "GetBookingStepDef.creatBooking(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user tries to get booking details using his booking id",
  "keyword": "When "
});
formatter.match({
  "location": "GetBookingStepDef.adding_booking_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response is returned with status code 200 for get booking api",
  "keyword": "Then "
});
formatter.match({
  "location": "GetBookingStepDef.verifyReponseCode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the data given in response body is equal to the data in request body for get booking api",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "GetBookingStepDef.verifyResponseBody(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Amendment of the created booking",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TestSuite"
    },
    {
      "name": "@UpdateBooking"
    }
  ]
});
formatter.step({
  "name": "user is able to authenticate and tokenid using credentials",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "username",
        "admin"
      ]
    },
    {
      "cells": [
        "password",
        "password123"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "UpdateBookingStepDef.authenticate(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user has created a new booking for stay to meet martians with details for updation",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "UpdateBookingStepDef.creatBooking(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides his ammended details",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Lunch"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "UpdateBookingStepDef.ammendBookingDetails(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response is returned with status code 200 for update booking api",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdateBookingStepDef.verifyReponseCode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the data given in response body is equal to the data in request body for update booking api",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Lunch"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "UpdateBookingStepDef.verifyResponseBody(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete existing booking",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TestSuite"
    },
    {
      "name": "@DeleteBooking"
    }
  ]
});
formatter.step({
  "name": "user is able to authenticate and tokenid using credentials to call deletion api",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "username",
        "admin"
      ]
    },
    {
      "cells": [
        "password",
        "password123"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "DeleteBookingStepDef.authenticate(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user has created a new booking for stay to meet martians with details for deletion",
  "rows": [
    {
      "cells": [
        "Detail",
        "Value"
      ]
    },
    {
      "cells": [
        "firstname",
        "Jim"
      ]
    },
    {
      "cells": [
        "lastname",
        "Brown"
      ]
    },
    {
      "cells": [
        "totalprice",
        "111"
      ]
    },
    {
      "cells": [
        "depositpaid",
        "true"
      ]
    },
    {
      "cells": [
        "checkin",
        "2018-01-01"
      ]
    },
    {
      "cells": [
        "checkout",
        "2019-01-01"
      ]
    },
    {
      "cells": [
        "additionalneeds",
        "Breakfast"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "DeleteBookingStepDef.creatBooking(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deletes the existing booking",
  "keyword": "When "
});
formatter.match({
  "location": "DeleteBookingStepDef.deleteBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response is returned with status code 201 for delete booking api",
  "keyword": "Then "
});
formatter.match({
  "location": "DeleteBookingStepDef.verifyReponseCode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "triggering get api for the deleted booking gives 404 status code",
  "keyword": "And "
});
formatter.match({
  "location": "DeleteBookingStepDef.verifyBookingIsDeleted()"
});
formatter.result({
  "status": "passed"
});
});