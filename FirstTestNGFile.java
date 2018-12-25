package firsttestngproject;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class FirstTestNGFile {
	
	
	
	public String url = "http://www.facebook.com";
	public WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		
		driver.get(url);
	}
	@Test
	public void verifyHomePageTitle()
	{
		String expectedTitle = "Welcome to Facebook - Log In, Sign Up or Learn More";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@AfterTest
	public void terminateBrowser()
	{
		driver.quit();
	}
	
}
	