Feature: Login TutorialsNinja application

 @All @ninja
 Scenario: Login to the application using valid credentials
	Given User navigates to login page of the application
	When User enters Username "endurance_osemwonta@gmail.com" and Password "Second@123" into the fields
	And I Click on the login button
	Then User should successfully login