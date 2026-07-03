package utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends ListenerLogic {
	@Parameters("Browser")
	
	@BeforeMethod
	public void lunchBrowser(String Browser) throws InterruptedException
	{
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(Browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		if(Browser.equals("safari"))
		{
			driver = new SafariDriver();
		}
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}


}
