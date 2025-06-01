package TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.MyAccPage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import TestBase.BaseClass;

public class TS004_Validate_SearchProduct_Functionality extends BaseClass{
	
	@Test(priority = 1 )
	public void TC001_Verify_WithValidSearchItem() {
		HomePage hp = new HomePage(driver);		
		hp.enterTextInSearchBox(prop.getProperty("existingProduct"));
		hp.clickOnSearch();
		
		SearchPage sp = new SearchPage(driver);
		String expectedTitle = "Search - "+prop.getProperty("existingProduct");
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
	}
	
	@Test(priority = 2 )
	public void TC002_Verify_WithNonExistingSearchItem() {
		HomePage hp = new HomePage(driver);		
		hp.enterTextInSearchBox(prop.getProperty("nonExistingProduct"));
		hp.clickOnSearch();
		
		SearchPage sp = new SearchPage(driver);
		String expectedTitle = "Search - "+prop.getProperty("nonExistingProduct");
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), false);
	}
	
	@Test(priority = 3 )
	public void TC003_Verify_WithBlankSearchField() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		Assert.assertEquals(sp.returnNoProductMsg(), "There is no product that matches the search criteria.");
	}
	
	@Test(priority = 4)
	public void TC004_Verify_SearchingAfterLogin() {
		driver = Login(driver);
			
		MyAccPage map = new MyAccPage(driver);
		map.enterTextInSearchBox(prop.getProperty("existingProduct"));
		map.clickOnSearch();
			
		SearchPage sp = new SearchPage(driver);
		String expectedTitle = "Search - "+prop.getProperty("existingProduct");
			
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
		}
		
	@Test(priority = 5)
	public void TC005_Verify_SearchUsingSearchCriteria() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
	}
	
	@Test(priority = 6)
	public void TC006_Verify_SearchUsingProductDescriptions() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("productDescription"));
		sp.selectSearchInProductDescription();
		sp.clickOnSearch();

		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
	}	
	
	@Test(priority=7)
	public void TC007_Verify_SearchBySelectProductCategory() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.selectCategoryFromDropDown(prop.getProperty("productCategory"));
		sp.clickOnSearch();
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
	}
	
	@Test(priority=8)
	public void TC008_Verify_SearchByProvidingParentCategoryWithoutSubcategoryOption() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("exitingProuductInSubCategory"));
		sp.selectCategoryFromDropDown(prop.getProperty("productCategory"));
		sp.clickOnSearch();
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), false);
	}
	
	@Test(priority = 9)
	public void TC009_Verify_SearchByProvidingParentCategoryWithSubCartegoryOption() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("exitingProuductInSubCategory"));
		sp.selectCategoryFromDropDown(prop.getProperty("productCategory"));
		sp.selectSubCategory();
		sp.clickOnSearch();
		Assert.assertEquals(sp.isExistingProductDisplayedInSearchResult(), true);
	}
	@Test(priority = 10)
	public void TC010_Verify_SearchSortOptionsFromDropDown(){
		ArrayList<String> originalList = new ArrayList<String> ();
		ArrayList<String> sortedList = new ArrayList<String>();
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.selectDropDropSortByOption("Name (A - Z)");
		List<WebElement> itemNames = sp.itemNames;
		for(WebElement op : itemNames) {
			String name=op.getText();
			originalList.add(name.toString().toLowerCase());
			sortedList.add(name.toString().toLowerCase());	
		}
		Collections.sort(sortedList);
		if(originalList.equals(sortedList)){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		sp.selectDropDropSortByOption("Price (High > Low)");
		ArrayList<Double> originalListPrice = new ArrayList<Double> ();
		ArrayList<Double> sortedListPrice = new ArrayList<Double>();
		List<WebElement> prices = sp.prices;
		for(WebElement op : prices) {
			String price=op.getText().split("\\$")[1].split("\n")[0].replace(",", "");
			originalListPrice.add(Double.parseDouble(price.toString()));
			sortedListPrice.add(Double.parseDouble(price.toString()));	
		}
		Collections.sort(sortedListPrice,Collections.reverseOrder());
		if(originalListPrice.equals(sortedListPrice)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 11)
	public void TC011_Verify_SearchByAddingElementToCart() {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		sp.clickOnAddToCart();
		String Msg = sp.returnAddToCartSuccessMsg();
		String actualMsg = Msg.split("\n")[0];
		String expMsg = "Success: You have added "+sp.itemName.getText()+ " to your shopping cart!";
		Assert.assertEquals(actualMsg, expMsg);		
	}
	
	@Test(priority = 12)
	public void TC012_Verify_SearchBySelectingProduct() throws Exception {
		HomePage hp = new HomePage(driver);		
		hp.clickOnSearch();
		SearchPage sp = new SearchPage(driver);
		sp.enterTextInSearchCriteriaField(prop.getProperty("multiResultProduct"));
		sp.clickOnSearch();
		String expTitle= sp.itemName.getText();
		sp.clickOnItem();
		Thread.sleep(5000);
		ProductPage pp = new ProductPage(driver);
		String actTitle = pp.getPageTitle();
		String Msg = sp.returnAddToCartSuccessMsg();
		String actualMsg = Msg.split("\n")[0];
		String expMsg = "Success: You have added "+sp.itemName.getText()+ " to your shopping cart!";
		Assert.assertEquals(actualMsg, expMsg);
		Assert.assertEquals(actTitle, expTitle);		
	}
	
	
	
}
