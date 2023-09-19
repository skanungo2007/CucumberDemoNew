package testRunner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		
			features = "src//test//resources//features//TelecomSmoke.feature",
			glue = {"stepDefinitions"},
			plugin = {"pretty", "html:target/html_report", "json:target/cucumber-reports/report.json", "junit:target/cucumber-reports/report.xml"},
			monochrome = true,
			dryRun = false,
			tags = "@Smoke"
			
			
		)


public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
