package implementation;

import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.HomePage;
import pages.WishListPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private WishListPage wishListPage;
	private CartPage cartPage;
	private TempVariable temp;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public WishListPage getWishListPage() {
		return (wishListPage == null) ? wishListPage = new WishListPage(driver) : wishListPage;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public TempVariable getTempVariable() {
		return (temp == null) ? temp = new TempVariable() : temp;
	}
}
