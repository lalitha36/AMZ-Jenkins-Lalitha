package selenium.testng.maven.SeleniumProgransInMavenProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(id="signInSubmit")
	private WebElement signIn;
	
	@FindBy(xpath=" //div/h1[contains(text(),'Sign in or create account')]")
	private WebElement textOfLoginPage;
	
	public void enterUsername() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys("lalithadevi.vegiraju@gmail.com");
		
	}
	public void clickOnContinue() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		
	}
	public void enterPassword() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(passWord));
		passWord.sendKeys("1234567");
		
	}
	public void clickOnSignIn() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
		
	}
//doing the next line for assertion
	public String verifyTheTextInLoginPageForAssertion() throws InterruptedException
	{
		
		 String atcualBehaviour = textOfLoginPage.getText();
		 return atcualBehaviour;
		
	}
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver ,this);
		this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(10));
	}

}
