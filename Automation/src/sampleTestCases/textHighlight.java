package sampleTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class textHighlight {
	@Test
	public void TextHighlight() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//open chrome browser
		WebDriver driver= new ChromeDriver();
		
		//maxmize the browser window
		driver.manage().window().maximize();
		
		//Enter the test url
		driver.get("https://katkada.com/");
		
		//gives text rgb color 
		String color = driver.findElement(By.xpath("//*[text()='Postpaid']")).getCssValue("color");
		String backcolor = driver.findElement(By.xpath("//*[text()='Postpaid']")).getCssValue("background-color");
		
		System.out.println(color);
		System.out.println(backcolor);
		
		if(!color.equals(backcolor))
		{
			System.out.println("Text is highlighted!");
		}
		
		else 
		{ 
			System.out.println("Text is not highlighted!");
		}
		}

}
