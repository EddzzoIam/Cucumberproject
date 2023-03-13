

Feature: Register for an account i tutorialninja application

@Register
Scenario: Register an account with valid details
	Given I navigates to Register page
	When I enter below details
	  |firstName|arun											|
		|lastName |motoori									|
		|email		|arun.seleniumabc@gmail.com	|
		|Telephone|12345678									|
		|password	|Second@123               |
	And I Selects the privacy policy option
	And I Clicks on Continue button
	Then User should be able to successfully register