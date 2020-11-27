package sampleTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getTitle {

	@Test
	public void Gettitle() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//open chrome browser
		WebDriver driver= new ChromeDriver();
		
		//maxmize the browser window
		driver.manage().window().maximize();
		
		//Enter the test url
		driver.get("https://katkada.com/");
	    
		//Used to get title of the current webpage
	    String actualTitle = driver.getTitle();
	    
	    //Expected title
	    String expectedTitle = "Katkada | Your Best Solution to choose best available mobile plans, dth connections and you can recharge and pay bills instantly online.";
	    
	    if(actualTitle.equals(expectedTitle))
	  {
		System.out.println("KatkadaPage is Displayed, Test Passed");
		
	  }
	}
}