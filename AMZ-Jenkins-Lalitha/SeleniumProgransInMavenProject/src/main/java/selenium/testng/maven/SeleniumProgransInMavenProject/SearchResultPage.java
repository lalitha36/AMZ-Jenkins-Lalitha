package selenium.testng.maven.SeleniumProgransInMavenProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> Produts;
	
	public void clickingOn1StProdut(WebDriver driver ) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(Produts.get(0)));
		Produts.get(0).click();
		
		Set<String> windows =driver.getWindowHandles();
		Iterator<String>all = windows.iterator();
		String pwind = all.next();
		String cwind = all.next();
		
		driver.switchTo().window(cwind);
	}
// constructor
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(10));
	}
	

}
