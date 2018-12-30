package firstProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class firstClass {
	public static void main(String []args)
	{
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
    System.out.println("Welcome to chrome");
	String url = "http://localhost:8080/BBC/index.html";
	WebDriver driver = new ChromeDriver();
	driver.get(url);
	String expectedTitle = " Technology - PTV News ";
	String actualTitle = driver.getTitle();
	if (actualTitle.contentEquals(expectedTitle))
	{
	System.out.println("Test Passed!");
	}
	else
	{
		System.out.println("Test Failed");
	}
	driver.quit();
	}
	
	}
		
	

