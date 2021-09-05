package stepDefinitions;

import implementation.PageObjectManager;
import implementation.TempVariable;
import implementation.TestContext;
import implementation.WebdriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.WishListPage;

public class Task1Steps {

	TestContext testContext;
	WebdriverManager webdriverManager;
	PageObjectManager pageObjectManager;
	HomePage homePage;
	WishListPage wishListPage;
	CartPage cartPage;
	TempVariable temp;

	public Task1Steps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		wishListPage = testContext.getPageObjectManager().getWishListPage();
		cartPage = testContext.getPageObjectManager().getCartPage();
		temp = testContext.getPageObjectManager().getTempVariable();
	}

	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list() {
		homePage.addProducts();

	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		wishListPage.viewWishList();
	}

	@Then("I find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		wishListPage.findNoOfItems();
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		String minAmount = wishListPage.searchLowestPriceProduct();
		temp.setMinPrice(minAmount);

	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
		String minPrice = temp.getMinPrice();
		String addLowestItem = wishListPage.addLowestItem(minPrice);
		temp.setLowestItem(addLowestItem);
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
		String lowestItem = temp.getLowestItem();
		cartPage.verifyItem(lowestItem);
	}

}