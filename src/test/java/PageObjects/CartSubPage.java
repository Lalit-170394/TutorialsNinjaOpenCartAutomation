package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSubPage extends BasePage{
	public CartSubPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//strong/i)[1]")
	WebElement btnViewCart;
	
	@FindBy(xpath = "(//td/button[@title='Remove'])[1]")
	WebElement btnRemove;
	
	public void clickOnViewCart() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btnViewCart);
	}
	
	public void clickOnRemove() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btnRemove);
	}
	
	

}
