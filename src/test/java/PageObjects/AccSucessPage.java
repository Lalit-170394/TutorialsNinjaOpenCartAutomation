package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccSucessPage extends BasePage{
	public AccSucessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@id='content']//h1")
	WebElement h1Msg;
	
	@FindBy(linkText = "Newsletter")
	WebElement btnNewLetter;
	
	public String msg() {
		return h1Msg.getText();
	}
	
	public void clickOnNewsletter() {
		btnNewLetter.click();
	}
	
	
}
