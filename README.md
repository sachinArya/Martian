# Martian Booking system Test

Version : 0.1

Date : 10.12.2019

***********************************************************
Background
***********************************************************
This Java utility enables us to test Booking API which enables the user to perform following functions
1) Create Booking
2) Update Booking
3) Get Booking
4) Delete Booking

***********************************************************
Pre-requisites
***********************************************************
In order to run this utility successfully following pre-requisites are to be met:

1) JDK 1.7 or newer
2) Eclipse (preferable Juno)
3) Maven Plugin for eclipse
4) GIT integration plug in for eclipse
5) Cucumber plugin



***********************************************************
Installation
***********************************************************
1)	Go to Eclipse > File > Import
2)	Select import source as "Projects from Git"
3)	Select Clone URI and enter "https://github.com/sachinArya/Martian.git"
4)	Click Next 
5)	Configure the local storage location for Martian project with default settings
6)	Import existing Eclipse projects
7)	Click finish
8)	Project has been downloaded and we can see it in Project Explorer pane
9)	Go to Project and right click to Update Project under “Maven” to resolve all dependencies

************************************************************
Running Tests
************************************************************
com.org.martian.bookings.tests.CucumberTestRunner is the used to configure the test suites. 
We can use cucumber option "@tags" to provide scenarios which we want to include in test run. 
We need to run this class as a JUnit test which will pick up the feature files provided in the cucumberoptions and will pick the corrosponding step definition files at the path provided in "glue" option.
Once the test run is complete we can see the test results in "testResults" folder > index.html
