package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishListPage {

	WebDriver driver;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "a[title='Wishlist']>i")
	private WebElement wishList;

	@FindBy(how = How.XPATH, using = "//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']")
	private WebElement wishListTable;

	@FindBy(how = How.XPATH, using = "//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']//tbody/tr")
	private List<WebElement> wishListTableRows;

	@FindBy(how = How.XPATH, using = "//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']//tbody/tr//td[@class='product-price']//bdi")
	private List<WebElement> wishListPriceColumn;

	public void viewWishList() {
		wishList.click();
	}

	public void findNoOfItems() {
		int noOfRows = wishListTableRows.size();
		Assert.assertEquals(noOfRows, 4);
	}

	public String searchLowestPriceProduct() {
		String resultingPrice = null;
		List<Integer> priceList = new ArrayList<>();
		for (int i = 1; i <= wishListTableRows.size(); i++) {
			resultingPrice = wishListTable
					.findElement(By.xpath("tbody//tr[" + i + "]//td[@class='product-price']//bdi")).getText();

			priceList.add(Integer.parseInt(resultingPrice.substring(1, 3)));
		}
		String minAmount = Collections.min(priceList).toString();
		return minAmount;

	}

	public String addLowestItem(String minPrice) {
		String selectedItem = null;
		List<WebElement> priceColumn = wishListPriceColumn;
		for (WebElement webElement : priceColumn) {
			if (webElement.getText().contains(minPrice)) {
				selectedItem = wishListTable.findElement(By.xpath("tbody//tr//td[@class='product-add-to-cart']//a"))
						.getAttribute("aria-label");
				wishListTable.findElement(By.xpath("tbody//tr//td[@class='product-add-to-cart']//a")).click();
				break;
			}
		}
		return selectedItem;
	}
}
