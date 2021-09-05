package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinitions",
		"pages" }, monochrome = true, plugin = { "pretty", "html:target/cucumber-reports/CucumberTestReport.html",
				"json:target/cucumber-reports/CucumberTestReport.json" }, tags = "@Task1")

public class RunTest extends AbstractTestNGCucumberTests {

}
