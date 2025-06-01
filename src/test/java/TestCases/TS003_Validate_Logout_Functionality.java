package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountLogoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccPage;
import TestBase.BaseClass;

public class TS003_Validate_Logout_Functionality extends BaseClass {
	
  @Test(priority = 1)
  public void TC001_Verify_LogoutThroughMyAccount() 
  {
	    HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		MyAccPage map = new MyAccPage(driver);
		map.clickMyAccount();
		map.clickLogout();	
		
		AccountLogoutPage alp = new AccountLogoutPage(driver);
		Assert.assertEquals(alp.returnHeadingText(),"Account Logout");		
  }
  
  @Test(priority = 2)
  public void TC002_Verify_LogoutThroughRightSidePanel() {
	  HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		MyAccPage map = new MyAccPage(driver);
		map.clickOnRightLogoutBtn();
		
		AccountLogoutPage alp = new AccountLogoutPage(driver);
		Assert.assertEquals(alp.returnHeadingText(),"Account Logout");
	  
  }
  
  @Test(priority = 3)
  public void TC003_Verify_LogoutAndBrowsingBack() {
	  //after browsing back user should navigated to login page
	  	HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		MyAccPage map = new MyAccPage(driver);
		map.clickOnRightLogoutBtn();
		
		driver.navigate().back();
		String title = driver.getTitle();
		if(title.equals(prop.getProperty("loginPageTitle"))) {
			Assert.assertTrue(true);
		}else {
			Assert.fail("User Should navigate to Login Page");
		}
		  
  }
  
}
