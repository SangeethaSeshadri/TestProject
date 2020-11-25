package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestcase {
	WebDriver driver;
	
	@Test(priority = 1)
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//open chrome browser
		driver= new ChromeDriver();
		
		//maxmize the browser window
		driver.manage().window().maximize();
		
		//Enter the test url
		driver.get("https://katkada.com/");
	    }
	
	
        @Test(priority = 2)
		public void getText()
		{
          //get the text 
		  String str = driver.findElement(By.xpath("//*[@id=\"recharge-form\"]/div/div[1]/label[1]")).getText();
		  System.out.println(str);
		  
		  //get the text 
		  String str1 = driver .findElement(By.xpath("//*[@id=\"recharge-form\"]/div/div[1]/label[2]")).getText();
	      System.out.println(str1);
		}
		
        @Test(priority = 3)
		public void displaytext()
		{
         //It check this text is displayed in webpage or not
		WebElement textDemo = driver.findElement(By.xpath("//*[text()='Prepaid']"));
		if(textDemo.isDisplayed())
		{
		System.out.println("Element found using text");
		}
		else
		System.out.println("Element not found");
		}
        
        
}

		
