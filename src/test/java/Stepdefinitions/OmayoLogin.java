package Stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OmayoLogin {
	
    WebDriver driver;
	
    
    @Before("@login")
public void setup() {
    	
    	driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Given("^I navigate to the omayo website$")
	public void I_navigate_to_the_omayo_website() {
		
	
		driver.get("http://www.omayo.blogspot.com");


}
	
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the fields$") 
	public void I_enter_Username_as_and_Password_as(String username,String password) {
		
		driver.findElement(By.name("userid")).sendKeys(username);
        driver.findElement(By.name("pswrd")).sendKeys(password);       
		
	}
	
	@And("^I click on Login button$")
	public void I_click_on_Login_button() {
		
		driver.findElement(By.cssSelector("input[type='button'][value='Login']")).click();	
		
	}
	
	@Then("^User should login based on expected \"([^\"]*)\" status$")
	public void User_should_login_based_on_expected_status(String expected) {
		
		String actualStatus = null;
		
		try {
			Alert alert = driver.switchTo().alert();
		
			if(alert.getText().contains("Error Password or Username")) {
				
				actualStatus = "failure";
			}
				
			
		}catch(Exception e) {
			
			actualStatus="success";		
		}
		
		
		
			Assert.assertEquals(expected,actualStatus);
		
		
	}
	@After("@login")
	public void closure() {
		
		driver.quit();	
		
	}
	
}





