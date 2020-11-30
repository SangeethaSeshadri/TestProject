package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPageObjects {
	
	public static WebElement signin(WebDriver driver) {
		return driver.findElement(By.linkText("SIGN IN"));
		}
   public static WebElement signinpopup(WebDriver driver) {
	   return driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	  }
   public static WebElement name(WebDriver driver) {
	   return driver.findElement(By.id("name"));
   }
   public static WebElement mobile(WebDriver driver) {
	   return driver.findElement(By.id("phone"));
   }
   public static WebElement emailId(WebDriver driver) {
	   return driver.findElement(By.id("email"));
   }
   public static WebElement password(WebDriver driver) {
	   return driver.findElement(By.id("password_signup"));
   }
   public static WebElement retypepass(WebDriver driver) {
	   return driver.findElement(By.id("confirm-pass"));
   }
}
