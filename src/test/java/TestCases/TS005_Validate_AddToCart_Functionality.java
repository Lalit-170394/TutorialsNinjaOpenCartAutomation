package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import TestBase.BaseClass;

public class TS005_Validate_AddToCart_Functionality extends BaseClass{


	@Test(priority = 1)
	public void TC001_Verify_AddedProductVisibleOnCartButton() throws Exception{
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		String cartText = sp.getTextOnCartButton().split(" ")[0];		
		Assert.assertTrue(Integer.parseInt(cartText)>0);		
	}
	
	@Test(priority = 2)
	public void TC002_Verify_AddToCartByAddingFromSearchResultPage() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		String cartText = sp.getTextOnCartButton().split(" ")[0];		
		Assert.assertTrue(Integer.parseInt(cartText)>0);
		
	}

	@Test(priority = 3)
	public void TC003_Verify_AddToCartByAddingFromProductsPage() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnItem();
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart();
		String cartText = sp.getTextOnCartButton().split(" ")[0];
		Assert.assertTrue(Integer.parseInt(cartText)>0);		
	}
	
	@Test(priority = 4)
	public void  TC004_Verify_AddToCartByAddingProductFromHomePage() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnAddToCart();
		SearchPage sp = new SearchPage(driver);
		String cartText = sp.getTextOnCartButton().split(" ")[0];
		Assert.assertTrue(Integer.parseInt(cartText)>0);		
	}
	
	
}
