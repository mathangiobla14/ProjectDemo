package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h2[text()='Single Shirt']/parent::a/following-sibling::div//span[text()='Add to wishlist']")
	WebElement product1;

	@FindBy(how = How.XPATH, using = "//h2[text()='Polo T-shirt']/parent::a/following-sibling::div//span[text()='Add to wishlist']")
	WebElement product2;

	@FindBy(how = How.XPATH, using = "//h2[text()='Hard top']/parent::a/following-sibling::div//span[text()='Add to wishlist']")
	WebElement product3;

	@FindBy(how = How.XPATH, using = "//h2[text()='Bikini']/parent::a/following-sibling::div//span[text()='Add to wishlist']")
	WebElement product4;

	public void addProducts() {
		product1.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
		product2.click();
		product3.click();
		product4.click();
	}
}
