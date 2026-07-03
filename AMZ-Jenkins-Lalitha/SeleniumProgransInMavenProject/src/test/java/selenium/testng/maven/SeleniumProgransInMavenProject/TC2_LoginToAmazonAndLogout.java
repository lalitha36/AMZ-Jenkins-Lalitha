package selenium.testng.maven.SeleniumProgransInMavenProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseTest;
import utility.RetryLogic;

public class TC2_LoginToAmazonAndLogout extends BaseTest{

	@Test(retryAnalyzer=RetryLogic.class)
	public void  loginAndLogOut() throws InterruptedException
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
		
		homePage.hoverOverAccountAndListAndSignOut(driver);
		Reporter.log("SignOut is successful");
		
		Assert.assertEquals(loginPage.verifyTheTextInLoginPageForAssertion(), "Sign in or create account","Sorry! Assertion of singOut is faild");
		Reporter.log("LogOut is done successfully and Test case is passed");
		
	//	Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Sorry! title counld not be same");
	//	Reporter.log("SignIn succesfull");
	}
}
