package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@id='content']//table[contains(@class, 'table')]/tbody/tr/td[@class='text-left']/a")
	List<WebElement> txtProductName;
	
	@FindBy(xpath = "(//button[@class='btn btn-danger'])[1]")
	WebElement btnRemove;
	
	@FindBy(xpath="(//td//input)[1]")
	WebElement txtQuantity;
	
	@FindBy(xpath="(//td//button[@data-original-title='Update'])[1]")
	WebElement btnUpdate;
	
	@FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
	WebElement msgUpdate;
	
	public int getNoOfProductFromCart() {
		if(txtProductName.size()!=0) 
		{
		return txtProductName.size();
		}
		else
		{
			return 0;
		}
	}
	
	public void clickOnRemove() {
		btnRemove.click();
		
	}
	
	public void updateQuantity(String qty) {
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
	}
	
	public void clickUpdateButton() {
		btnUpdate.click();
	}
	
	public String getUpdateMsg() {
		String Msg = msgUpdate.getText().split("\n")[0];
		return Msg; 
	}
	
}
