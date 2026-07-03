package selenium.testng.maven.SeleniumProgransInMavenProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseTest;
import utility.RetryLogic;

public class Tc4_LoginSearchingWishlistAddToCart extends BaseTest {
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginSearchWishListAddTocart() throws InterruptedException
	{
		Reporter.log("Browser is launched successfully");
		HomePage homePage = new HomePage(driver);
		homePage.hoverOverOnAccountAndList(driver);
		homePage.clickOnSignIn();
		
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUsername();
		loginPage.clickOnContinue();
		loginPage.enterPassword();
		loginPage.clickOnSignIn();
		Reporter.log("Login is done successfully");
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Sorry! title counld not be same");
		Reporter.log("SignIn succesfull and Test case is passed");
		
		homePage.searchingProduct();
		Reporter.log("Searching the product");
		
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickingOn1StProdut(driver);
		Reporter.log("Clicking on the 1st product");
		
		Assert.assertEquals(driver.getWindowHandles().size()>1, true , "Soory! Assertion is faild at clicking the 1st product");
		Reporter.log("Test case is passed");
		
		ProductDetailedPage productpage = new ProductDetailedPage(driver);
		productpage.clickOnWishList();
	//	productpage.clickOnCreateButton();
		productpage.clickOncontinueShopping();
		productpage.addToCart();
		Reporter.log("product is addded in the cart ");
		String actual = driver.getTitle();
		System.out.println(actual);
		
	//	Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart" , "Sorry! Asertion of titlle has not have cart");
		Reporter.log("Test case is passed");
	}

}
