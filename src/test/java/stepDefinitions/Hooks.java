package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import implementation.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	WebDriver driver = null;
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	public Hooks(WebDriver driver) {
		this.driver = driver;
	}

	@Before()
	public void beforeScenario() {
//		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
//		driver.get("https://testscriptdemo.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	@After()
	public void afterScenario() {
		testContext.getWebdriverManager().getDriver().quit();
	}

}
