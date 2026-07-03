package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerLogic implements ITestListener{
	public static WebDriver driver;
	public String date()
	{
		Date a = new Date();
		System.out.println(a);
		Date  a1 = new Date(a.getTime());
		String  f = a1.toString();
		String  f1 = f.replace(":", " ");
		 
		return f1;
		
	}
	
    
	
	public void onTestSuccess(ITestResult result) {
		
		
		
		ITestListener.super.onTestSuccess(result);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sour = ts.getScreenshotAs(OutputType.FILE);
		File dis = new File("C:\\ManishTiwariAutomationTestingWithAIPromte.Batch66\\SeleniumProgransInMavenProject\\test-output\\SreenShots\\PassMaven"+new ListenerLogic().getClass()+date()+result.getName()+".png");
		try {
			FileHandler.copy(sour, dis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sour = ts.getScreenshotAs(OutputType.FILE);
		File dis = new File("C:\\ManishTiwariAutomationTestingWithAIPromte.Batch66\\SeleniumProgransInMavenProject\\test-output\\SreenShots\\FailMaven\\"+new ListenerLogic().getClass()+date()+result.getName()+".png");
		try {
			FileHandler.copy(sour, dis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
