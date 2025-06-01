package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccPage extends BasePage {
	public MyAccPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement hTitle;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement navMyAccount;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement navLogout;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement rtBtLogout;
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement txtSearchBox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;   
	
	public boolean isPageExist() {
		try {
			return hTitle.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickNavLogout() {
		navLogout.click();
	}
	public void clickMyAccount() {
		navMyAccount.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

	public boolean isUserLoggedIn() {
		boolean res=false;
		try {		 
			res = btnLogout.isDisplayed();		 
		}catch(Exception e) {
			System.out.println("Exception");
			res = false;
		}
		return res;
	}
	
	public void clickOnRightLogoutBtn() {
		rtBtLogout.click();
	}
	
	public void enterTextInSearchBox(String searchText) {
		txtSearchBox.sendKeys(searchText);		
	}
	 public void clickOnSearch() {
		 btnSearch.click();
	 }

}
