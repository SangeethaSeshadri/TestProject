package testNG;


import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.SignInPageObjects;

public class KatkadaWebPage extends BaseClass {
	

		//SignButton on top left(MenuBar)
		@Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
		   public void Signin() throws InterruptedException, IOException 
		  {
			testCase = extentReport.createTest("SignIn");
			Thread.sleep(2000);
			PageFactory.initElements(driver, SignInPageObjects.class);
			SignInPageObjects.signin.click();
			testCase.log(Status.INFO, "Login Katkada WebPage");	
			}
		
		//Check the Signup popup
		@Test(description="TestCasesID #T.C.1.1.002",priority = 2)
		public void SignupPopup() throws InterruptedException
		{
			   testCase = extentReport.createTest("SignupPopup");
			   Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   
			   SignInPageObjects.signinpopup.click();
			   testCase.log(Status.INFO, "Checked a SignupPopup");
			   testCase.log(Status.INFO, "Checked the Input Field For SignupPopup");
			   SignInPageObjects.name.sendKeys("Sangeetha");
			   SignInPageObjects.mobile.sendKeys("9442513153");
			   SignInPageObjects.emailId.sendKeys("sangeetha1200@gmail.com");
			   SignInPageObjects.password.sendKeys("sangeetha");
			   SignInPageObjects.retypepass.sendKeys("sangeetha");
			   
			   String actualtext= SignInPageObjects.signup.getText();
			   System.out.println(actualtext);
			   String expectedtext = "Sign Up";
			   Assert.assertEquals(actualtext, expectedtext);
			   if(actualtext.equals(expectedtext)) {
				   testCase.log(Status.PASS, "Actual text and Expected text are equal");
			   }else {
				   testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
			   }
			   
		}
		
		//Check the Forgetpassword Popup
		@Test(description="TestCasesID #T.C.1.1.002",priority = 3)
		public void ForgetpasswordPopup() throws InterruptedException 
		{
			  testCase = extentReport.createTest("ForgetpasswordPopup");
			  Thread.sleep(2000);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  
			  SignInPageObjects.forgetpass.click();
			  testCase.log(Status.INFO, "Checked a ForgetPasswordPopup");
			  testCase.log(Status.INFO, "Checked a Input File for forgetpasswordPopup");
			  SignInPageObjects.emailid.sendKeys("sangeetha1200@gmail.com");
			 
			  String actualtext = SignInPageObjects.forgetpassbutton.getText();
			  System.out.println(actualtext);
			  String expectedtext = "Reset Password";
			  Assert.assertEquals(actualtext, expectedtext);
			  if(actualtext.equals(expectedtext)) {
				  testCase.log(Status.PASS, "Actual text and Expected text are equal");
			  }else {
				  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
			  }
		  
		 }
		
		 //Check SignIn Button
		 @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 4)
		 public void SignInButton() throws InterruptedException 
		 {
			  testCase = extentReport.createTest("SignInButton");
		      Thread.sleep(2000);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
			  //Click on SignIn Popup
			  SignInPageObjects.signIn.click();
			  testCase.log(Status.INFO, "Checked a SignInpopup");
			  testCase.log(Status.INFO, "Checked the Input Field for SignInPopup");
			  //Fill the email field
			  SignInPageObjects.email.sendKeys("sa@gmail.com");
			  testCase.log(Status.INFO, "Vaild Email");
			  //Fill the password field
	          SignInPageObjects.pass.sendKeys("shanthi123");
	          testCase.log(Status.INFO, "Valid Password");
	          //"SIGN IN" button
			  SignInPageObjects.SignInbutton.click();
			  testCase.log(Status.INFO, "Checked the SignIn Button");
			  
	      }
		 
		 @Test(description = "TestCasesID #T.C.1.1.006",priority = 5)
		 public void image() throws InterruptedException {
			 Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   SignInPageObjects.image.click();
			  
			   SignInPageObjects.logout.click();
			  String alrtmsg = driver.switchTo().alert().getText();
			  System.out.println(alrtmsg);
			  String expectmessage = "Are you sure want to Logout Now?";
			  Assert.assertEquals(alrtmsg, expectmessage);
			  Thread.sleep(1000);
			  driver.switchTo().alert().accept();
			  
		 }
		
}


