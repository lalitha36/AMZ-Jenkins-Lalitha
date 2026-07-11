package selenium.testng.maven.SeleniumProgransInMavenProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@id='brandsRefinements']/ul/span/span")
	private List<WebElement> brandNames;
	
	@FindBy(xpath ="//div[@id='brandsRefinements']/descendant::span[text()='The Derma Co']/preceding-sibling::div/label/i")
	private WebElement dermacoProduct;
	
	@FindBy(xpath="//ul[@id='filter-p_36']/span/span[2]")
	private WebElement pricefilter;
	
	
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
	public void verifySearchFiltersWithBrands() throws InterruptedException
	{
	//verify search filters with Brands
		wait.until(ExpectedConditions.visibilityOfAllElements(brandNames));
		int countOfBrands = brandNames.size();
		System.out.println(countOfBrands);
		
		for(int i =0; i<countOfBrands; i++)
		{
			WebElement brands = brandNames.get(i);
			String text = brands.getText();
			
			System.out.println(text);
			Thread.sleep(1000);
			
		}
	// dermoco product
		 wait.until(ExpectedConditions.elementToBeClickable(dermacoProduct));
		dermacoProduct.click();
	}	
	
	public void  verifySearchFiltersWithprice()
	{
		 wait.until(ExpectedConditions.elementToBeClickable(pricefilter));
		 pricefilter.click();
	}
// constructor
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(10));
	}
	

}
