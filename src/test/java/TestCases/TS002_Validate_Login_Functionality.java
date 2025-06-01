package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ForgottonPasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccPage;
import TestBase.BaseClass;

public class TS002_Validate_Login_Functionality extends BaseClass{
	
	@Test(priority = 1)
	public void TC001_Verify_LoginWithValidCredientials() {
		try {
				System.out.println("TC001_Verify_LoginWithValidCredientials");
				//logger.info("*******TC002_Login started*******");
				HomePage hp = new HomePage(driver);
				hp.clickMyAcc();
				hp.clickLogin(driver);
				//logger.info("clicking on login");
				LoginPage lp = new LoginPage(driver);
				//logger.info("entering user details");
				lp.setUsername(prop.getProperty("username"));
				lp.setPassword(prop.getProperty("password"));
				lp.clickLogin();
				
				MyAccPage map = new MyAccPage(driver);
				boolean status = map.isPageExist();
				System.out.println(status);
				Assert.assertEquals(status, true);
				//logger.info("******Test Passed********");
		}catch(AssertionError e) {
//			logger.error(e.getMessage());
//			logger.info("******** Test Failed **********");
			Assert.fail();
		}
		finally {
			//logger.info("*******TC002_Login finished*******");
		}
		
	}
	
	@Test(priority = 2)
	public void TC002_Verify_LoginWithInValidCredientials() {
		System.out.println("TC002_Verify_LoginWithInValidCredientials");
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			//logger.info("entering user details");
			lp.setUsername(prop.getProperty("invalidUserName"));
			lp.setPassword(prop.getProperty("invalidpassword"));
			lp.clickLogin();
			
			String alert = lp.returnAlertMsg();
			String ExpAlert = "Warning: No match for E-Mail Address and/or Password.";
			
			//logger.info("******Test Passed********");
			Assert.assertEquals(alert, ExpAlert);
		
	}
	
	@Test(priority = 3)
	public void TC003_Verify_LoginWithInValidEmailAndValidPassword() {
		System.out.println("TC003_Verify_LoginWithInValidEmailAndValidPassword");
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			//logger.info("entering user details");
			lp.setUsername(randomEmail());
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			String alert = lp.returnAlertMsg();
			String ExpAlert = "Warning: No match for E-Mail Address and/or Password.";
			
			//logger.info("******Test Passed********");
			Assert.assertEquals(alert, ExpAlert);
		
	}
	
	@Test(priority = 4)
	public void TC004_Verify_LoginWithValidEmailAndInValidPassword() {
		
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			//logger.info("entering user details");
			lp.setUsername(prop.getProperty("username"));
			lp.setPassword(randomPass());
			lp.clickLogin();
			
			String alert = lp.returnAlertMsg();
			String ExpAlert = "Warning: No match for E-Mail Address and/or Password.";
			
			//logger.info("******Test Passed********");
			Assert.assertEquals(alert, ExpAlert);
		
	}
	
	@Test(priority = 5)
	public void TC005_Verify_LoginWithoutCredientials() {
		System.out.println("TC005_Verify_LoginWithoutCredientials");
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			lp.clickLogin();			
			String alert = lp.returnAlertMsg();
			String ExpAlert = "Warning: No match for E-Mail Address and/or Password.";			
			//logger.info("******Test Passed********");
			Assert.assertEquals(alert, ExpAlert);
		
	}
	
	@Test(priority = 6)
	public void TC006_Verify_ElementPlaceHolders() {
		
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			String ActualEmailPlaceHolder = lp.getEmailPlaceholder();
			String ActualPasswordPlaceHolder = lp.getPasswordPlaceholder();
			
			String ExpEmailPlaceHolder = "E-Mail Address";
			String ExpPasswordPlaceholder = "Password";
			//logger.info("******Test Passed********");
			Assert.assertEquals(ActualEmailPlaceHolder, ExpEmailPlaceHolder);
			Assert.assertEquals(ActualPasswordPlaceHolder, ExpPasswordPlaceholder);
		
	}
	
	@Test(priority = 7)
	public void TC007_Verify_ForgottonPasswordLink() {
		System.out.println("TC007_Verify_ForgottonPasswordLink");
			//logger.info("*******TC002_Login started*******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			lp.clickOnForgottonPassword();
			ForgottonPasswordPage fpp=new ForgottonPasswordPage(driver);
			String ActTitle = fpp.returnPageTitle();
			Assert.assertEquals(ActTitle,"Forgot Your Password?");
	}
	
	@Test(priority = 8)
	public void TC008_Verify_BrowserBackActionAfterLogin() {
		try {
			System.out.println("TC008_Verify_BrowserBackActionAfterLogin");
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			//logger.info("clicking on login");
			LoginPage lp = new LoginPage(driver);
			//logger.info("entering user details");
			lp.setUsername(prop.getProperty("username"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			driver.navigate().back();
			MyAccPage map = new MyAccPage(driver);		
			boolean status = map.isUserLoggedIn();
			Assert.assertEquals(status, true);
		} catch (AssertionError e) {			
			Assert.fail();			
		}catch (Exception e) {
		Assert.fail("Browser Back Action Failed");
		} 	
	}
}
