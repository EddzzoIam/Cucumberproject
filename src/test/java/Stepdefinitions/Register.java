package Stepdefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	
	WebDriver driver;
	@Before("@Register")
	

	public void OpenBroswer() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
	}
	
	 @Given("^I navigates to Register page$")
	    public void i_navigates_to_register_page() {
		 driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	        
	    }

	    @When("^I enter below details$")
	    public void i_enter_below_details(DataTable data) {
	    	
	    	 Map<String, String> dataMap = data.asMap(String.class, String.class);
	    	 
	    	 driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	 		 driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	 		 driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
	 		 driver.findElement(By.name("telephone")).sendKeys(dataMap.get("Telephone"));
	 		 driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	 		 driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	    }

	   
	    @And("^I Selects the privacy policy option$")
	    public void i_selects_the_privacy_policy_option()  {
	    	
	    	driver.findElement(By.name("agree")).click();
	    
	    }

	    @And("^I Clicks on Continue button$")
	    
	    public void i_clicks_on_continue_button() {
	    	driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();
	        
	    }
	    
	    @Then("^User should be able to successfully register$")
	    public void user_should_be_able_to_successfully_register()  {
	    	
	    	String url = driver.getCurrentUrl();
			
			if(url.equals("http://tutorialsninja.com/demo/index.php?route=account/success")) {
				
				
				
			}else {
				
				System.out.println("User has not registered");
				
				Assert.fail("User has not registered");
				
			}
			
	       
	    }
	    
	    public void Closure() {
	    	
	    	driver.close();
	    }


}
