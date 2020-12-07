package mobilepostpaid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.PostpaidPageObject;
import testNG.BaseClass;

public class MobilePostpaidModule extends BaseClass{
	
	 //SignButton on top left(MenuBar)
	 @Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
	 public void Signin() throws InterruptedException 
      {
		testCase = extentReport.createTest("SignIn for Postpaid Module");
		Thread.sleep(2000);
		PageFactory.initElements(driver, PostpaidPageObject.class);
		PostpaidPageObject.signin.click();
		testCase.log(Status.INFO, "Login Katkada Webpage");
       }

      //Check SignIn Button
      @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
      public void SignInButton() throws InterruptedException 
      {
    	 testCase = extentReport.createTest("SignInButton");
         Thread.sleep(2000);
         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         PostpaidPageObject.email.sendKeys("sa@gmail.com");
         testCase.log(Status.INFO, "Valid Email");
         PostpaidPageObject.pass.sendKeys("shanthi123");
         testCase.log(Status.INFO, "Valid Password");
         PostpaidPageObject.SignInbutton.click();
         testCase.log(Status.INFO, "Checked the SignIn Button");
    } 

	
	  @Test(description="TestCasesID #T.C.1.3.001",priority = 3)
	  public void postpaid() throws InterruptedException
	  {
		 testCase = extentReport.createTest("Postpaid Module");
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 PostpaidPageObject.mobiles.click();
			
		 Thread.sleep(1000);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     PostpaidPageObject.postpaid.click();
	     testCase.log(Status.INFO, "Checked Postpaid Module");
	
		 String actualtext = PostpaidPageObject.headline.getText();
		 System.out.println(actualtext);
		 String expectedtext = "Bill Payment";
		 Assert.assertEquals(actualtext, expectedtext);
		 if(actualtext.equals(expectedtext)) {
			  testCase.log(Status.PASS, "Actual text and Expected text are equal");
		  }else {
			  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
		  }
	  }
	  
	  @Test(description="TestCasesID #T.C.1.3.002, #T.C.1.3.003" ,priority = 4)
	  public void postpaidvalidInputs() throws InterruptedException 
	  {
		 testCase = extentReport.createTest("Postpaid Positive Scenarios");
		 testCase.log(Status.INFO, "Checked with Vaild Inputs");
		 PostpaidPageObject.mobileno.sendKeys("9445637281");
		 testCase.log(Status.INFO, "Valid Mobile Number");
	
		 PostpaidPageObject.operator.click();
		 Select drpope = new Select(PostpaidPageObject.drpop);
		 drpope.selectByVisibleText("Idea");
		 testCase.log(Status.INFO, "Selected the Operator");
		 
		 
		 PostpaidPageObject.regio.click();
		 Select drpre = new Select(PostpaidPageObject.drore);
		 drpre.selectByVisibleText("TAMIL NADU");
		 testCase.log(Status.INFO, "Selected the Region");
		 
		 
		 PostpaidPageObject.amount.sendKeys("200");
		 testCase.log(Status.INFO, "Valid Amount");
		
		 Thread.sleep(1000);
		 PostpaidPageObject.paybill.sendKeys(Keys.ENTER);
		 testCase.log(Status.INFO, "Checked PayBill button");
		 
		 Thread.sleep(2000);
		 PostpaidPageObject.mobiles.click();
		 
      }
 
      //Check with invalid user details - with signin
      @Test(description="TestCasesID #T.C.1.3.004, #T.C.1.3.005, #T.C.1.3.006, #T.C.1.3.007",priority = 5)
      public void postpaidNegativeScenarios() throws InterruptedException 
      {
    	 testCase = extentReport.createTest("Postpaid Negative Scenarios");
	     Thread.sleep(2000);
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     PostpaidPageObject.postpaid.click();
	
	//Invalid mobile number, other fields with valid input
	    testCase.log(Status.INFO, "Invalid Mobile Number Other field with Valid inputs");
	    PostpaidPageObject.mobileno.sendKeys("944325432");
	 
	    PostpaidPageObject.operator.click();
	    Select drpope = new Select(PostpaidPageObject.drpop);
	    drpope.selectByVisibleText("Idea");
	 
	    PostpaidPageObject.regio.click();
	    Select drpre = new Select(PostpaidPageObject.drore);
	    drpre.selectByVisibleText("TAMIL NADU");
	  
	    PostpaidPageObject.amount.sendKeys("200");
	    
	    PostpaidPageObject.paybill.click();
	  
	    String alertMessage = driver.switchTo().alert().getText();
	    System.out.println(alertMessage);
	    String expectedMessage = "Enter a valid 10 digits mobile number!";
	    Assert.assertEquals(alertMessage, expectedMessage);
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	 
	 
	  //clear the input field
	   
	   PostpaidPageObject.mobileno.clear();
	 
	   PostpaidPageObject.operator.click();
	   drpope.selectByVisibleText("-- Select Operator --");
	 
	   PostpaidPageObject.regio.click();
	   drpre.selectByVisibleText("-- Select Region --");
	 
	   PostpaidPageObject.amount.clear();
	 
	 
    //select operator field has to be empty, other fields with valid input
	   testCase.log(Status.INFO, "Select Operator field is empty, other fields with valid input");
	   PostpaidPageObject.mobileno.sendKeys("9445673821");
	 
	   PostpaidPageObject.regio.click();
	   drpre.selectByVisibleText("TAMIL NADU");

	   PostpaidPageObject.amount.sendKeys("300");
	 
	   PostpaidPageObject.paybill.sendKeys(Keys.ENTER);
	 
	   String AlertMessage = driver.switchTo().alert().getText();
	   System.out.println(AlertMessage);
	   String ExpectedMessage = "Select the operator name.";
	   Assert.assertEquals(AlertMessage, ExpectedMessage);
	   Thread.sleep(1000);
	   driver.switchTo().alert().accept();
	 
	 //clear the input
	 
	   PostpaidPageObject.mobileno.clear();
	 
	   PostpaidPageObject.regio.click();
	   drpre.selectByVisibleText("-- Select Region --");
	 
	   PostpaidPageObject.amount.clear();
	 
	//Select region has to be empty, other field with valid input
	   testCase.log(Status.INFO, "Select Region field is empty, other field with valid inputs ");
	   PostpaidPageObject.mobileno.sendKeys("9445673821");
	 
	   PostpaidPageObject.operator.click();
       drpope.selectByVisibleText("Idea");
		
	   PostpaidPageObject.amount.sendKeys("200");
		
	   PostpaidPageObject.paybill.sendKeys(Keys.ENTER);
		
	   String alertmessage = driver.switchTo().alert().getText();
	   System.out.println(alertmessage);
	   String expectedmessage = "Select the region name.";
	   Assert.assertEquals(alertmessage, expectedmessage);
		
	   Thread.sleep(1000);
	   driver.switchTo().alert().accept();
		
	  //clear the input
		
	   PostpaidPageObject.mobileno.clear();
		
	   PostpaidPageObject.operator.click();
	   drpope.selectByVisibleText("-- Select Operator --");
		
	   PostpaidPageObject.amount.clear();
		
	  //invalid amount, other field with valid input
	  testCase.log(Status.INFO, "Invalid amount,other fields with valid inputs");
	  PostpaidPageObject.mobileno.sendKeys("9445637281");
		
	  PostpaidPageObject.operator.click();
	  drpope.selectByVisibleText("Idea");
		
	  PostpaidPageObject.regio.click();
	  drpre.selectByVisibleText("TAMIL NADU");
		
	  PostpaidPageObject.amount.sendKeys("0");
		
	  PostpaidPageObject.paybill.click();
		
	  String alrtmsg = driver.switchTo().alert().getText();
	  System.out.println(alrtmsg);
      String expectmsg = "Enter valid amount between 1 to 50000";
	  Assert.assertEquals(alrtmsg, expectmsg);
		
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
		
	  //clear the input field
		
	  PostpaidPageObject.mobileno.clear();
		 
	  PostpaidPageObject.operator.click();
	  drpope.selectByVisibleText("-- Select Operator --");
		 
	  PostpaidPageObject.regio.click();
	  drpre.selectByVisibleText("-- Select Region --");
	  
	  PostpaidPageObject.amount.clear();
	  
		 
  }
      
      @Test(description = "TestCasesID #T.C.1.1.006",priority = 6)
		 public void image() throws InterruptedException {
			 Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   PostpaidPageObject.image.click();
			  
			   PostpaidPageObject.logout.click();
			  String alrtmsg = driver.switchTo().alert().getText();
			  System.out.println(alrtmsg);
			  String expectmessage = "Are you sure want to Logout Now?";
			  Assert.assertEquals(alrtmsg, expectmessage);
			  Thread.sleep(1000);
			  driver.switchTo().alert().accept();
      }

 }
