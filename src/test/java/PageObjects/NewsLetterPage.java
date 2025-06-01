package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLetterPage extends BasePage{
	public NewsLetterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//input[@value='0']")
	WebElement radioNo;
	
	@FindBy(xpath = "//input[@value='1']")
	WebElement radioYes;
	
	public boolean isSelectedNO() {
		return radioNo.isEnabled();
	}
	
	public boolean isSelectedYes() {
		return radioYes.isEnabled();
	}

}
