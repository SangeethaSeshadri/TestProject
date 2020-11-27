package testNG;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public WebDriver driver;
	 
	@BeforeTest
	public void LaunchBrowse() 
	{
		System.out.println("Enter Browser Name");
		Scanner sc = new Scanner(System.in);
		String browserName = sc.next();
		
		
		if(browserName.equals("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
		    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		  //maxmize the browser window
          driver.manage().window().maximize();
		
          //Enter the test url
		  driver.get("https://katkada.com/");
	}
	
	 @AfterTest
	 public void CloseBrowser() throws InterruptedException {
		 
		Thread.sleep(2000);
		driver.quit();
		 
	 }

}
