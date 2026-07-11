package selenium.testng.maven.SeleniumProgransInMavenProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;
import utility.RetryLogic;

public class TC6_LoginVerifySearchWithFilters extends BaseTest {
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void verifySerachFilters() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
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
	searchResultPage.verifySearchFiltersWithBrands();
	softAssert.assertEquals(driver.getTitle(), "Amazon.in: Sunscreen - 964140" , "Sorry! Brand name is not matched");
	searchResultPage.verifySearchFiltersWithprice();
	softAssert.assertEquals(driver.getTitle(), "Amazon.in: Sunscreen - 964140 / ₹350 - ₹600" , "Sorry! BandName and price is not matched");
	Reporter.log("Verify seach result to get accurate resuls");
	
	
	Reporter.log("Test case is passed");
	softAssert.assertAll();
	}
	

}
