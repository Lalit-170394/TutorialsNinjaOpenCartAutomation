package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;	
//constructor
	public HomePage(WebDriver driver){
		super(driver);//constructor of immediate parent class i.e. BaseClass
					  //used inheritance here to increase the re-usability
	}
	
	//locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement nav_myAccout;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement nav_register;
	
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")
	WebElement nav_login;
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement txtSearchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;  
	
	@FindBy(xpath="(//div[@class='button-group']/button)[1]")
	WebElement btnAddToCart; 
	
	
	//action methods
	public void clickMyAcc()
	{
		nav_myAccout.click();
	}
	
	public void clickRegister(WebDriver driver)
	{
		//nav_register.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", nav_register);
	}
	
	public void clickLogin(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", nav_login);
		//nav_login.click();
	}
	
	public void enterTextInSearchBox(String searchText) {
		txtSearchBox.sendKeys(searchText);		
	}
	 public void clickOnSearch() {
		 btnSearch.click();
	 }
	 
	 public void clickOnAddToCart() {
		 btnAddToCart.click();
	 }
}
