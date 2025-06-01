package PageObjects;

import org.openqa.selenium.WebDriver;

public class ForgottonPasswordPage extends BasePage{
	public ForgottonPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public String returnPageTitle() {
		return driver.getTitle();
	}

}
