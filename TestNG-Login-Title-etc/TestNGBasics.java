package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBasics {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:18331/Login");
	}
	
	@Test
	public void verifyPageTitleTest() {
		String title=driver.getTitle();
		System.out.print("the page title is "+ title);
		Assert.assertEquals(title, "It is myDiary");
		
	}
	@Test
	public void verifyFreeCRMLogoTest() {
		boolean flag=driver.findElement(By.xpath("//img[@src='/Images/people 2.jpg']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
