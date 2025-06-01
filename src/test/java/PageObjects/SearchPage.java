package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='product-thumb']")
	WebElement searchResult;
	
	@FindBy(xpath = "//p[contains(text(),'no product')]")
	WebElement msgNoProduct;
	
	@FindBy(xpath= "//input[@id='input-search']")
	WebElement txtSearchCriteria;
	
	@FindBy(xpath= "//input[@id='button-search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//input[@id='description']")
	WebElement chkDescription;
	
	@FindBy(xpath = "//select[@name='category_id']")
	WebElement dropDownProductCategory;
	
	@FindBy(xpath = "//input[@name='sub_category']")
	WebElement chkSubCategory;
	
	@FindBy(xpath = " //select[@id='input-sort']")
	WebElement dropDownSort;	
	
	
	@FindBy (xpath = "//h4")
	public List<WebElement> itemNames;	
	
	@FindBy(xpath = "(//h4/a)[1]")
	public WebElement itemName;
	
	@FindBy(xpath="(//div[@class='button-group']/button)[1]")
	WebElement btnAddtoCart;
	@FindBy(xpath="(//button[@type='button'])[12]")
	WebElement btnAddtoCartSecond;
	
	@FindBy (xpath = "//p[@class='price']")
	public List<WebElement> prices;	
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msgSuccessAddToCart;
	
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnCart;
	
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement navBtnShoppingCart;
	
	public boolean isExistingProductDisplayedInSearchResult() {
		try {
			return searchResult.isDisplayed();			
		}catch(Exception e) {
			return false;
		}
	}
	
	public String returnNoProductMsg() {
		return msgNoProduct.getText();
	}
	
	public void enterTextInSearchCriteriaField(String searchtext) {
		txtSearchCriteria.sendKeys(searchtext);
	}
	
	public void clickOnSearch() {
		btnSearch.click();
	}
	
	public void selectSearchInProductDescription() {
		if(!chkDescription.isSelected()) {
			 chkDescription.click();
		}
	}

	public void selectCategoryFromDropDown(String value) {
		dropDownProductCategory.click();
		Select catDropDown = new Select(dropDownProductCategory);
		catDropDown.selectByVisibleText(value);
	}
	
	public void selectSubCategory() {
		if(!chkSubCategory.isSelected()) {
		chkSubCategory.click();
		}
	}
	
	public void selectDropDropSortByOption(String text) {
		dropDownSort.click();
		Select drpSort = new Select(dropDownSort);
		drpSort.selectByVisibleText(text);		
	}
	
	public void clickOnAddToCart() {
		btnAddtoCart.click();
	}
	
	public String returnAddToCartSuccessMsg() {
		return msgSuccessAddToCart.getText();
	}
	
	public void clickOnItem() {
		itemName.click();
	}
	
	public String getTextOnCartButton() throws Exception {
		Thread.sleep(3000);
		return btnCart.getText();	
	}
	
	public void clickOnAddToCartSec() {
		btnAddtoCartSecond.click();		
	}
	
	public void clickOnCartButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btnCart);
		//btnCart.click();
	}
	
	public void clickOnShoppinCartButtonFromNavigationBar() {
		navBtnShoppingCart.click();
	}
}
