package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/java/features/getIncidents.feature"},
		glue = {"steps","hooks"},
		monochrome = true,
		publish = true,
		//tags="@Regression"
		//tags="not @Regression"
		tags="API Tests"
		)


public class Runner extends AbstractTestNGCucumberTests{

	
	
}
