package TestNGSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class commentBoxTest {
	WebDriver driver;
	
	@Test
	public void textAreaTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:18331/Home/Index");
		
		driver.findElement(By.xpath("//*[@id='Post1']")).clear();
		driver.findElement(By.xpath("//*[@id='Post1']")).sendKeys("any comment");
		
		driver.findElement(By.xpath("//*[@class='btn-primary']")).click();
		System.out.println("Comented");
		
		
	}

}
