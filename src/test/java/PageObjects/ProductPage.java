package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnAddToCart;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnAddToCart() {
		btnAddToCart.click();		
	}
}
