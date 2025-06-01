package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccSucessPage;
import PageObjects.HomePage;
import PageObjects.NewsLetterPage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TS001_Validate_Register_Functionality extends BaseClass{
	
	
	@Test(priority = 1)
	public void TC001_Verify_RegisterWithAllFields() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		//logger.info("Entering the user details......");
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(randomMobile());		
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		//logger.info("Validating........");
		AccSucessPage asp = new AccSucessPage(driver);
		Assert.assertEquals(asp.msg(),"Your Account Has Been Created!");
		//logger.info("******** Test Passed **********");		
	}
	
	//@Test(priority = 2)
	public void TC002_Verify_RegisterWithOnlyMandetoryFields() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		//logger.info("Entering the user details......");
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(randomMobile());		
		rp.setPassword(pass);
		rp.setCnfpass(pass);		
		rp.clickAgree();
		rp.clickContinue();
		//logger.info("Validating........");
		AccSucessPage asp = new AccSucessPage(driver);
		Assert.assertEquals(asp.msg(),"Your Account Has Been Created!");
		//logger.info("******** Test Passed **********");		
	}
	
	@Test(priority = 3)
	public void TC003_Verify_RegisterWithMissingMandetoryField() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		//logger.info("Entering the user details......");
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		//not providing telephone number		
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		Assert.assertEquals(rp.getWarning(rp.telWarning),"Telephone must be between 3 and 32 characters!");
		//logger.info("******** Test Passed **********");		
	}
	
	@Test(priority = 4)
	public void TC004_Verify_AllWarningMessages() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		RegistrationPage rp = new RegistrationPage(driver);
		rp.clickContinue();
		Assert.assertEquals(rp.getWarning(rp.FnameWarning), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(rp.getWarning(rp.LnameWarning), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(rp.getWarning(rp.emailWarning), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(rp.getWarning(rp.passwordWarning), "Password must be between 4 and 20 characters!");
		Assert.assertEquals(rp.getWarning(rp.telWarning),"Telephone must be between 3 and 32 characters!");
				
	}
	
	@Test(priority = 5)
	public void TC005_Verify_ByProvidingInvalidEmail() {
		String invalidEmail = randomInvalidEmail();
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(invalidEmail);
		rp.setTelephone(randomMobile());		
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		String msg="Please include an '@' in the email address. '"+invalidEmail+"' is missing an '@'.";
//		System.out.println(rp.returnEmailMsg());
//		boolean st = msg.equalsIgnoreCase(rp.returnEmailMsg());
//		System.out.println(st);
		Assert.assertEquals(rp.returnEmailMsg(),msg);
		} 
	@Test (priority=6)
	public void TC006_Verify_ByProvidingInvalidTelephone() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(invalidPhoneNumber());			
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		Assert.assertEquals(rp.getWarning(rp.telWarning),"Telephone must be between 3 and 32 characters!");
		
	}
	
	@Test(priority = 7)
	public void TC007_Verify_ByProvidingAlphanumericTelephone() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(alphaNumericPhoneNumber());			
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		AccSucessPage asp = new AccSucessPage(driver);
		if(asp.msg().equals("Your Account Has Been Created!")) {
			Assert.fail("Telephone Number Should not be Alphanumeric");
		}else {
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority = 8)
	public void TC008_Verify_UnSubribingNewsLetter()  {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(alphaNumericPhoneNumber());			
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickNo();
		rp.clickAgree();
		rp.clickContinue();
		AccSucessPage asp = new AccSucessPage(driver);
		Assert.assertEquals(asp.msg(),"Your Account Has Been Created!");
		asp.clickOnNewsletter();		
		NewsLetterPage nlp = new NewsLetterPage(driver);
		Assert.assertTrue(nlp.isSelectedNO());
	}
	
	@Test(priority = 9)
	public void TC009_Verify_SubribingNewsLetter()  {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(alphaNumericPhoneNumber());			
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		AccSucessPage asp = new AccSucessPage(driver);
		Assert.assertEquals(asp.msg(),"Your Account Has Been Created!");
		asp.clickOnNewsletter();		
		NewsLetterPage nlp = new NewsLetterPage(driver);
		Assert.assertTrue(nlp.isSelectedYes());
	}
	
	@Test(priority = 10)
	public void TC010_Verify_ByUncheckingTerms()  {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		String pass = randomPass();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(alphaNumericPhoneNumber());			
		rp.setPassword(pass);
		rp.setCnfpass(pass);
		rp.clickYes();
		rp.clickContinue();
		Assert.assertEquals(rp.getWarning(rp.warningMsg), "Warning: You must agree to the Privacy Policy!");
	}
	
	@Test(priority = 11)
	public void TC011_Verify_ByProvidingDifferentPassInConfirmField()  {
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickRegister(driver);	
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomName());
		rp.setLastName(randomLastName());
		rp.setEmail(randomEmail());
		rp.setTelephone(alphaNumericPhoneNumber());			
		rp.setPassword(randomPass());
		rp.setCnfpass(randomPass());
		rp.clickYes();
		rp.clickAgree();
		rp.clickContinue();
		Assert.assertEquals(rp.getWarning(rp.cnfPasswordWarning), "Password confirmation does not match password!");
	}

}
