package selenium.testng.maven.SeleniumProgransInMavenProject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private  WebDriver driver;
	private WebDriverWait wait ;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement account_list;
	
	@FindBy(xpath="//a[@class='nav-action-signin-button']")
	 private WebElement signIn;
	
	@FindBy(xpath="//a[@id='nav-item-signout']/span[text()='Sign Out']")
	 private WebElement signOut;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	public void hoverOverOnAccountAndList(WebDriver driver) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(account_list));
		Actions a =new Actions(driver);
		a.moveToElement(account_list).perform();
		Thread.sleep(2000);
	}
	public void clickOnSignIn() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
		
	}
	public void hoverOverAccountAndListAndSignOut(WebDriver driver) throws InterruptedException
	{
		hoverOverOnAccountAndList(driver);
		wait.until(ExpectedConditions.elementToBeClickable(signOut));
		
		signOut.click();
	}
//sir is done
	public void SignOut(WebDriver driver) throws InterruptedException
	{
		Actions a =new Actions(driver);
		a.moveToElement(account_list).perform();
		Thread.sleep(2000);
		signOut.click();
		Thread.sleep(2000);
		
	}
	public void searchingProduct() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys("sunscream"+Keys.ENTER);
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this );
		this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(10));
	}
	
	
	

}
