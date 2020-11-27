package testNG;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatkadaWebPage extends BaseClass {
	

		//SignButton on top left(MenuBar)
		@Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
		   public void Signin() throws InterruptedException 
		  {
			//pause the execution for 2 seconds
			Thread.sleep(2000);
			
			//click the SIGN IN button
			driver.findElement(By.linkText("SIGN IN")).click();
			
			}
		
		//Check the Signup popup
		@Test(description="TestCasesID #T.C.1.1.002",priority = 2)
		   public void SignupPopup() throws InterruptedException
		{
			   Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   
			   WebElement signup = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
			   signup.click();
			   
			   WebElement name = driver.findElement(By.id("name"));
			   name.sendKeys("Sangeetha");
			   
			   WebElement mobileno = driver.findElement(By.id("phone"));
			   mobileno.sendKeys("9445643127");
			   
			   WebElement emailid = driver.findElement(By.id("email"));
			   emailid.sendKeys("sangeethas120@gmail.com");
			   
			   WebElement pass = driver.findElement(By.id("password_signup"));
			   pass.sendKeys("sangeetha");
			   
		       WebElement retypepass =driver.findElement(By.id("confirm-pass"));
			   retypepass.sendKeys("sangeetha");
			   
			   String actualtext= driver.findElement(By.xpath("//button[@id='sign_up_button']")).getText();
			   System.out.println(actualtext);
			   String expectedtext = "Sign Up";
			   Assert.assertEquals(actualtext, expectedtext);
			   
		}
		
		//Check the Forgetpassword Popup
		@Test(description="TestCasesID #T.C.1.1.002",priority = 3)
		   public void ForgetpasswordPopup() throws InterruptedException 
		{
			  Thread.sleep(2000);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  WebElement forgetpass = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
			  forgetpass.click();
			  
			  WebElement emailId = driver.findElement(By.id("email-form1"));
			  emailId.sendKeys("sangeetha120@gmail.com");
			  
			  String actualtext = driver.findElement(By.xpath("//button[@id='reset_pwd_button']")).getText();
			  System.out.println(actualtext);
			  String expectedtext = "Reset Password";
			  Assert.assertEquals(actualtext, expectedtext);
			  
		 }
		
		 //Check SignIn Button
		 @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 4)
		 public void SignInButton() throws InterruptedException 
		 {
		   
		      Thread.sleep(2000);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  //Click on SignIn Popup
			  WebElement signIn = driver.findElement(By.linkText("Sign In"));
			  signIn.click();
			
		      //Fill the email field
			  WebElement email = driver.findElement(By.id("email-form"));
			  //Fill the password field
	          WebElement password = driver.findElement(By.id("pass-form"));
	          //"SIGN IN" button
			  WebElement signin = driver.findElement(By.xpath("//*[@id=\"sign_in_button\"]"));
			
			  //fill the email field using this validinput(Email)
			  Thread.sleep(1000);
	          email.sendKeys("sa@gmail.com");
	        
	          //fill the password field using this validinput(password)
	          Thread.sleep(1000);
	          password.sendKeys("shanthi123");
	        
	          //Click on "SIGIN" button
	          Thread.sleep(1000);
	          signin.click();
	      }
		
}


