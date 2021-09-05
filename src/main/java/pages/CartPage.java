package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "a[title='Cart']>i")
	private WebElement addToCart;

	@FindBy(how = How.XPATH, using = "//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
	private WebElement cartTable;

	public void verifyItem(String lowestItem) {
		addToCart.click();
		String itemInCart = cartTable.findElement(By.xpath("tbody//tr//td[@class='product-name']")).getText();
		Assert.assertTrue(lowestItem.contains(itemInCart));
		System.out.println("The Element " + itemInCart + " is present in the cart");
	}
}
