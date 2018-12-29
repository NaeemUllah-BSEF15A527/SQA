package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://freecrm.com");
		login("naeem","123");
		driver.switchTo().frame("mainpanel");
	}
	@Test(priority=1)
	public void clickOnContactsLinkTest() {
		driver.switchTo().frame("mainpanel");
		WebElement contacts=driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
		contacts.click();
	}
	@Test(priority=2)
	public void clickOnDealsLinkTest() {
		driver.switchTo().frame("mainpanel");
		WebElement deals=driver.findElement(By.xpath("//a[contains(text(),'Diary')]"));
		deals.click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	public void login(String username,String password ) {
		driver.findElement(By.name("Email")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
		//login btn
		
		WebElement loginbtn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginbtn);
	}
}
