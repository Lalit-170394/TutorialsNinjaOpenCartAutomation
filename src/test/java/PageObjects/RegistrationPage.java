package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@placeholder='E-Mail']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@placeholder='Telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@placeholder='Password Confirm']")
	WebElement txtCnfPassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement radNewsLetterYes;
	
	@FindBy(xpath = "//label[normalize-space()='No']//input[@name='newsletter']")
	WebElement radNewsLetterNo;
	
	@FindBy(xpath= "//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement h1Msg;
	
	@FindBy(xpath="//input[@type='tel']//following-sibling::div")
	public WebElement telWarning;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	public WebElement FnameWarning;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	public WebElement LnameWarning;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	public WebElement emailWarning;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	public WebElement passwordWarning;
	
	@FindBy(xpath="//input[@name='confirm']/following-sibling::div")
	public WebElement cnfPasswordWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	public WebElement warningMsg;
	
	
	public void setFirstName(String fname){
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname){
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone){
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void setCnfpass(String cPass)
	{
		txtCnfPassword.sendKeys(cPass);
	}
	
	public void clickYes()
	{
		radNewsLetterYes.click();
	}
	
	public void clickNo() {
		radNewsLetterNo.click();
	}
	
	public void clickAgree() {
		chkAgree.click();
	}
	
	public void clickContinue()	{
		btnContinue.click();
	}
	
	
	public String getWarning(WebElement element) {
		if(element==telWarning) {
			return telWarning.getText();
		}else if(element == FnameWarning){
			return FnameWarning.getText();
		}else if(element== LnameWarning) {
			return LnameWarning.getText();
		}else if(element == emailWarning) {
			return emailWarning.getText();
		}else if(element==passwordWarning) {
			return passwordWarning.getText();
		}else if(element == warningMsg){
			return warningMsg.getText();			
		}else if(element == cnfPasswordWarning){
			return cnfPasswordWarning.getText();
		}else {
			return null;
		}
	}
	
	public String returnEmailMsg() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", txtEmail);
        return validationMessage;
   	}
	
	
	
}
