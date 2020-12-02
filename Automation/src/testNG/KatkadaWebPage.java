package testNG;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SignInPageObjects;

public class KatkadaWebPage extends BaseClass {
	

		//SignButton on top left(MenuBar)
		@Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
		   public void Signin() throws InterruptedException 
		  {
			//pause the execution for 2 seconds
			Thread.sleep(2000);
			PageFactory.initElements(driver, SignInPageObjects.class);
			//click the SIGN IN button
			SignInPageObjects.signin.click();
			
			}
		
		//Check the Signup popup
		@Test(description="TestCasesID #T.C.1.1.002",priority = 2)
		public void SignupPopup() throws InterruptedException
		{
			   Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   
			   SignInPageObjects.signinpopup.click();
			   SignInPageObjects.name.sendKeys("Sangeetha");
			   SignInPageObjects.mobile.sendKeys("9442513153");
			   SignInPageObjects.emailId.sendKeys("sangeetha1200@gmail.com");
			   SignInPageObjects.password.sendKeys("sangeetha");
			   SignInPageObjects.retypepass.sendKeys("sangeetha");
			   
			   String actualtext= SignInPageObjects.signup.getText();
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
			  
			  SignInPageObjects.forgetpass.click();
			  SignInPageObjects.emailid.sendKeys("sangeetha1200@gmail.com");
			 
			  String actualtext = SignInPageObjects.forgetpassbutton.getText();
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
			  SignInPageObjects.signIn.click();
			  //Fill the email field
			  SignInPageObjects.email.sendKeys("sa@gmail.com");
			  //Fill the password field
	          SignInPageObjects.pass.sendKeys("shanthi123");
	          //"SIGN IN" button
			  SignInPageObjects.SignInbutton.click();
			  
	      }
		
}


