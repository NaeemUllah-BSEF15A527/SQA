package TestNGSessions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlesExample {
	
	@Test
	public void handleWindow()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		d1.get("http://www.naukri.com");
		d1.manage().window().maximize();
		String parentWindow = d1.getWindowHandle();
		Set<String> set1 = d1.getWindowHandles();
		String childWindow = "";
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext())
		{
			childWindow = it1.next();
			if(!parentWindow.equals(childWindow))
			{
				System.out.println(d1.switchTo().window(childWindow).getTitle());
				d1.switchTo().window(childWindow);
				d1.close();
			}
		}
		
		d1.switchTo().window(parentWindow);
	}
}
	
	
	
	
	

	


