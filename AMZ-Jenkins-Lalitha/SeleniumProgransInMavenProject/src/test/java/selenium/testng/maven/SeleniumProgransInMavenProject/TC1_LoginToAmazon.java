package selenium.testng.maven.SeleniumProgransInMavenProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseTest;
import utility.ListenerLogic;
import utility.RetryLogic;
@Listeners(ListenerLogic.class)
public class TC1_LoginToAmazon extends BaseTest{
	
	@Test(retryAnalyzer=RetryLogic.class)
	public void validCredentials() throws InterruptedException
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
	}

}
