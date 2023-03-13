package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(

		plugin = "html:target/cucumber_html_report.html", 
		monochrome= true,
		
		features = "src/test/java/Features", 
		glue = "Stepdefinitions",
		tags="@Register"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
