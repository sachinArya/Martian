package com.org.martian.bookings.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"}
		,glue = {"com.org.martian.bookings.tests"}
		,strict = false
		,dryRun = false
		,monochrome = true
		,tags={"@Create"}
		)

public class CucumberTestRunner {

}
