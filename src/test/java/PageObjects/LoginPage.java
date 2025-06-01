package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement txtAlert;
	
	@FindBy(linkText = "Forgotten Password")
	WebElement linkForgottonPass;
	
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String returnAlertMsg() {
		return txtAlert.getText();
	}
	
	public String getEmailPlaceholder() {
		return txtUsername.getDomAttribute("placeholder");
	}
	
	public String getPasswordPlaceholder() {
		return txtPassword.getDomAttribute("placeholder");
	}
	
	public void clickOnForgottonPassword() {
		linkForgottonPass.click();
	}

	public boolean isLoginPageExist() {
		if(driver.getTitle().equals("Account Login")){
			return true;
		}else {
			return false;
		}
	}
}
