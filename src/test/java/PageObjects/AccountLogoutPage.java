package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogoutPage extends BasePage{
	public AccountLogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement txtHeading;
	
	
	
	public String returnHeadingText() {
		return txtHeading.getText();
	}
	

}
