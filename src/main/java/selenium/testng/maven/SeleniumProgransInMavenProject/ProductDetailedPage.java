package selenium.testng.maven.SeleniumProgransInMavenProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailedPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishList;
	
	@FindBy(xpath="//span[@data-action='create-list-submit']//input[@type='submit']")
	 private WebElement creatAddToYourList;
	
	@FindBy(xpath="//span[text()='Continue shopping']/parent::span/parent::span")
	private WebElement continueShopping;
	
	@FindBy(xpath="//span[@id='submit.add-to-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="(//div[@id='corePrice_feature_div'])[1]")
	private WebElement verifyPrice;
	
	@FindBy(xpath ="//div[@id='averageCustomerReviews_feature_div']")
	private WebElement verifyReview;
	
	@FindBy(xpath="(//hr[@class='bucketDivider'])[1]")
	private WebElement verifyProducDetails;
	
	
	public void clickOnWishList() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(addToWishList));
		addToWishList.click();
	}
	public void clickOnCreateButton() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(creatAddToYourList));
		creatAddToYourList.click();
	}
	public void clickOncontinueShopping() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
		continueShopping.click();
	}
	public void addToCart() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}
	public boolean isPriceDispayed()
	{
		return verifyPrice.isDisplayed();
	}
	public boolean isReviewDispayed()
	{
		return verifyReview.isDisplayed();
	}
	
	public boolean isProductdetailedDispayed()
	{
		return verifyProducDetails.isDisplayed();
	}
	
	public ProductDetailedPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(10));
	}
	

}
