package implementation;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TempVariable {
	
	private List<String> priceList;
	public String minAmount;
	private List<WebElement> priceColumn;
	public String lowestItem;

	public TempVariable() {
	}

	public void setPriceList(List<String> priceList) {
		this.priceList = priceList;
	}
	
	public List<String> getPriceList(){
		return priceList;
	}

	public void setMinPrice(String minAmount) {
		this.minAmount = minAmount;
	}
	
	public String getMinPrice(){
		return minAmount;
	}

	public void setLowestItem(String lowestItem) {
		this.lowestItem= lowestItem;
	}
	
	public String getLowestItem(){
		return lowestItem;
	}
}
