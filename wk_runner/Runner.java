package wk_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/wk_features/"},
glue = {"wk_steps","wk_hooks"},
monochrome = true,
publish = true
)

public class Runner extends AbstractTestNGCucumberTests {

}

