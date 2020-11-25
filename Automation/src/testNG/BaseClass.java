package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	WebDriver driver;
	 
	@BeforeTest
	public void LaunchBrowse() 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//open chrome browser
		driver = new ChromeDriver();
		
		//maxmize the browser window
        driver.manage().window().maximize();
		
        //Enter the test url
		driver.get("https://katkada.com/");
	}
	
	 @AfterTest
	 public void CloseBrowser() throws InterruptedException {
		 
		 Thread.sleep(1000);
		 driver.quit();
		 
	 }

}
