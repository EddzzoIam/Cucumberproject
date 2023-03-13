package Stepdefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	
	@Before("@ninja")
	public void openBrowser() {
	
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}

	
	@Given("User navigates to login page of the application")
	public void user_navigates_to_login_page_of_the_application()  {
		
	 driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		
	}


    @When("^User enters Username \"([^\"]*)\" and Password \"([^\"]*)\" into the fields$")
    public void user_enters_username_something_and_password_something_into_the_fields(String emailaddress, String password) {
       
    	driver.findElement(By.id("input-email")).sendKeys(emailaddress);
    	driver.findElement(By.id("input-password")).sendKeys(password);
    }


    @And("^I Click on the login button$")
    public void i_click_on_the_login_button() {
       
    
    	
    driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
       
    }
    

    @Then("^User should successfully login$")
    public void user_should_successfully_login()  {
    	
    	  WebElement accountbreadcrum = null;
    	   
    
    	  
    try {
    	accountbreadcrum  = driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Account']"));
    
    }catch(Exception exc) {
    	
    	System.out.println("login has fail");
    	
    	
    }
    
 Assert.assertNotEquals(accountbreadcrum,"the test got failed");
    }
    
    
    @After
    public void closure() {
    	driver.quit(); 
    }

	
}
	


