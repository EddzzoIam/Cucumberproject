
Feature: Login to the omayo application 
@login
Scenario Outline: User should only be able to login with valid credentials
Given I navigate to the omayo website
When I enter Username as "<username>" and Password as "<password>" into the fields
And I click on Login button 
Then User should login based on expected "<Expected>" status

Examples:
|username		|password	|Expected	|
|arun    		|pswd1    	|failure   	|
|SeleniumByArun	|Test143$	|success	|
|motoori		|pswd2		|failure 		|

