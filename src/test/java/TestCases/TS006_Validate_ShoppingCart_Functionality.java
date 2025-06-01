 package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartSubPage;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import PageObjects.ShoppingCartPage;
import TestBase.BaseClass;

public class TS006_Validate_ShoppingCart_Functionality extends BaseClass{
	
	@Test(priority = 1)
	public void TC001_Verify_ShoppingCartByNavigatingThroughCartButton() {
			HomePage hp = new HomePage(driver);		
			hp.clickOnSearch();
			SearchPage sp = new SearchPage(driver);
			sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
			sp.clickOnSearch();
			sp.clickOnAddToCart();
			sp.clickOnAddToCartSec();
			sp.clickOnCartButton();
			CartSubPage cartSubPage = new CartSubPage(driver);
			cartSubPage.clickOnViewCart();
			ShoppingCartPage cart = new ShoppingCartPage(driver);
			int a = cart.getNoOfProductFromCart();
			Assert.assertTrue(a>0);
		}
	 
	@Test(priority = 2)
	public void TC002_Verify_ShoppingCartByNavigatingThroughNavigationBar() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		sp.clickOnAddToCartSec();
		sp.clickOnShoppinCartButtonFromNavigationBar();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		int a = cart.getNoOfProductFromCart();
		Assert.assertTrue(a>0);
	}
	
	@Test(priority = 3)
	public void TC003_Verify_ShoppingCartButtonWithZeroItemAdded() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		String cartText = sp.getTextOnCartButton().split(" ")[0];
		Assert.assertTrue(Integer.parseInt(cartText)==0);
	}
	
	@Test(priority = 4)
	public void TC004_Verify_ShoppingCartByRemovingProductFromSubCartPage() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		//sp.clickOnAddToCartSec();
		sp.clickOnCartButton();
		CartSubPage cart = new CartSubPage(driver);
		cart.clickOnRemove();
		String cartText = sp.getTextOnCartButton().split(" ")[0];
		System.out.println(cartText);
		Assert.assertTrue(Integer.parseInt(cartText)==0);	
	}
	
	@Test(priority = 5)
	public void TC005_Verify_ShoppingCartByRemovingProductFromShoppingCartPage() throws Exception{
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		sp.clickOnAddToCartSec();
		sp.clickOnShoppinCartButtonFromNavigationBar();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		int a = cart.getNoOfProductFromCart();
		cart.clickOnRemove();
		Thread.sleep(2000);
		int b = cart.getNoOfProductFromCart();
		System.out.println(a+" "+b);
		Assert.assertTrue(b<a);		
	}
	
	@Test(priority = 6)
	public void TC006_Verify_ShoppingCartByUpdatingQuantity() throws Exception{
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		sp.clickOnAddToCartSec();
		sp.clickOnShoppinCartButtonFromNavigationBar();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		String cartText = sp.getTextOnCartButton().split(" ")[0];
		cart.updateQuantity(prop.getProperty("quantity"));
		cart.clickUpdateButton();
		String actualMsg = cart.getUpdateMsg();
		Thread.sleep(2000);
		System.out.println(actualMsg);
		String reqMsg ="Success: You have modified your shopping cart!";
		String cartTextUpdated = sp.getTextOnCartButton().split(" ")[0];
		System.out.println(cartText+" "+cartTextUpdated);
		Assert.assertEquals(actualMsg, reqMsg);		
		Assert.assertTrue(Integer.parseInt(cartTextUpdated)>Integer.parseInt(cartText));
		
	}
	
	@Test(priority = 7)
	public void TC007_Verify_ShoppingCartByUpdatingQuantityUsingNegativeNumber() throws Exception{
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		sp.clickOnAddToCartSec();
		sp.clickOnShoppinCartButtonFromNavigationBar();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		int productNo = cart.getNoOfProductFromCart();
		cart.updateQuantity(prop.getProperty("quantityNegative"));
		cart.clickUpdateButton();
		String actualMsg = cart.getUpdateMsg();
		Thread.sleep(2000);
		System.out.println(actualMsg);
		String reqMsg ="Success: You have modified your shopping cart!";
		int productNoUpdated = cart.getNoOfProductFromCart();
		System.out.println(productNo+" "+productNoUpdated);
		Assert.assertEquals(actualMsg, reqMsg);	
		Assert.assertEquals(productNoUpdated, productNo,"product is removed");
		//Assert.assertTrue(Integer.parseInt(cartTextUpdated)<Integer.parseInt(cartText));
		
	}
	
	@Test(priority = 8)
	public void TC008_Verify_ShoppingCartByUpdatingQuantityByProvidingZero() throws Exception{
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		sp.clickOnAddToCartSec();
		sp.clickOnShoppinCartButtonFromNavigationBar();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		int productNo = cart.getNoOfProductFromCart();
		cart.updateQuantity("0");
		cart.clickUpdateButton();
		String actualMsg = cart.getUpdateMsg();
		Thread.sleep(2000);
		System.out.println(actualMsg);
		String reqMsg ="Success: You have modified your shopping cart!";
		int productNoUpdated = cart.getNoOfProductFromCart();
		System.out.println(productNo+" "+productNoUpdated);
		Assert.assertEquals(actualMsg, reqMsg);	
		//Assert.assertEquals(productNoUpdated, productNo,"product is removed");
		Assert.assertTrue(productNoUpdated<productNo);
		
	}
	
	
	

}
