package mobileprepaid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.PrepaidPageObject;
import testNG.BaseClass;

public class MobilePrepaidModule extends BaseClass {
	
	   
       @Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
	   public void Signin() throws InterruptedException 
		  {
    	       
    	        testCase = extentReport.createTest("SignIn for Prepaid Module");
				Thread.sleep(2000);
				PageFactory.initElements(driver, PrepaidPageObject.class);
				PrepaidPageObject.signin.click();
				testCase.log(Status.INFO, "Login Katkada Webpage");
		  }
	
	   
	   @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
	   public void SignInButton() throws InterruptedException 
	    {  
		  testCase = extentReport.createTest("SignInButton");
	      Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  PrepaidPageObject.email.sendKeys("sa@gmail.com"); 
		  testCase.log(Status.INFO, "Valid Email");
          PrepaidPageObject.pass.sendKeys("shanthi123");
          testCase.log(Status.INFO, "Valid Password");
          PrepaidPageObject.SignInbutton.click();
          testCase.log(Status.INFO, "Checked the SignIn Button");
          
        }
	  
 
	   //Check (recharge - Prepaid Module) with SignIn
	   @Test(description="TesctCasesID #T.C.1.2.001",priority = 3)
	   public void Prepaid() throws InterruptedException 
	   {
		 testCase = extentReport.createTest("Prepaid Module");
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Click on "Mobile" - present on navigate bar(top left)
		 PrepaidPageObject.mobile.click();
		 testCase.log(Status.INFO, "Checked Prepaid Module");
		 
		 String actualtext = PrepaidPageObject.rechargenow.getText();
		 System.out.println(actualtext);
		 String expectedtext = "Recharge Now";
		 Assert.assertEquals(actualtext, expectedtext);	
		 if(actualtext.equals(expectedtext)) {
			  testCase.log(Status.PASS, "Actual text and Expected text are equal");
		  }else {
			  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
		  }
		 
		
	   }
	 
	  //Check with User Valid inputs
      @Test(description="TestCasesID #T.C.1.2.002",priority = 4)
      public void prepaidValidInputs() 
       {
    	 testCase = extentReport.createTest("Prepaid Positive Scenarios");
    	 testCase.log(Status.INFO, "Checked with Vaild Inputs");
   	     PrepaidPageObject.mobileno.sendKeys("8904321238");
   	     testCase.log(Status.INFO, "Valid Mobile Number");
		  
		 PrepaidPageObject.operator.click();
		 Select drpope = new Select(PrepaidPageObject.drpop);
		 drpope.selectByVisibleText("Idea");
		 testCase.log(Status.INFO, "Selected the Operator");
		 
		 PrepaidPageObject.region.click();
		 Select drpreg = new Select(PrepaidPageObject.drpre);
		 drpreg.selectByVisibleText("CHENNAI");
		 testCase.log(Status.INFO, "Selected the Region");
		 
	     PrepaidPageObject.amount.sendKeys("100");
	     testCase.log(Status.INFO, "Valid Amount");
		 
	  }
	 
    //Check browse plan link
	@Test(description="TestCasesID #T.C.1.2.003",priority = 5)
	public void browserplan() throws InterruptedException
	 {
		 testCase = extentReport.createTest("BrowserPlan");
		 //Click on browserplan Link
		 Thread.sleep(2000);
	     PrepaidPageObject.plan.click();
	     testCase.log(Status.INFO, "Checked the BrowserPlanLink");
		 
		 //Click on Plantype dropdown
		 Thread.sleep(2000);
		 PrepaidPageObject.plans.click();
		 testCase.log(Status.INFO, "Checked the Plans");
	     Thread.sleep(1000);
		 Select drpplan = new Select(PrepaidPageObject.drpplans);
		 drpplan.selectByVisibleText("Special Tariff");
		 testCase.log(Status.INFO,"Selected the Plan");
		 
		
		 //Close Browserplan popup
		 Thread.sleep(1000);
		 PrepaidPageObject.browser.click();
		 testCase.log(Status.INFO, "Closed the Browserplan");
		 

	  }
	 
	//Check recharge Button
	@Test(description="TestCasesID #T.C.1.2.004",priority = 6)
	public void rechargenowButton() throws InterruptedException
	 {
		 testCase = extentReport.createTest("RechargeNow");
		 //Click on "recharge" button
		 Thread.sleep(1000);
		 PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		 testCase.log(Status.INFO, "Checked RechargeNow button");
		 
		 String actualtext = PrepaidPageObject.information.getText();
         System.out.println(actualtext);
         String expectedtext ="Recharge Amount Information";
         Assert.assertEquals(actualtext, expectedtext);
         if(actualtext.equals(expectedtext)) {
			  testCase.log(Status.PASS, "Actual text and Expected text are equal");
		  }else {
			  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
		  }
	  }
	 
	 
	  //Negative Scenarios for prepaid 
	  @Test(description="TestCasesID #T.C.1.2.005, #T.C.1.2.006, #T.C.1.2.007, #T.C.1.2.008",priority = 7)
	  public void PrepaidNegativeScenarios() throws InterruptedException
	  {
		 testCase = extentReport.createTest("Prepaid Negative Scenarios");
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 PrepaidPageObject.mobile.click();
		 
		 //Check with invalid user details - with signin
		 //Invalid mobile number, other fields with valid input
		 
		 PrepaidPageObject.mobileno.sendKeys("944253613");
		 testCase.log(Status.INFO, "Invalid Mobile Number Other field with Valid inputs");
		 
		 PrepaidPageObject.operator.click();
		 Select drpope = new Select(PrepaidPageObject.drpop);
		 drpope.selectByVisibleText("Idea");
		 
		 PrepaidPageObject.region.click();
		 Select drpreg = new Select(PrepaidPageObject.drpre);
		 drpreg.selectByVisibleText("CHENNAI");
		 
		 PrepaidPageObject.amount.sendKeys("200");
		 Thread.sleep(1000);
		 PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		 
		 String alertMessage = driver.switchTo().alert().getText();
		 System.out.println(alertMessage);
		 String expectedMessage = "Enter a valid 10 digits mobile number!";
		 Assert.assertEquals(alertMessage, expectedMessage);
		 
		 Thread.sleep(2000);
		 driver.switchTo().alert().accept();
		 
		 //clear the input fields
		 
		PrepaidPageObject.mobileno.clear();
		
		PrepaidPageObject.operator.click();
		drpope.selectByVisibleText("-- Select Operator --");
		 
		PrepaidPageObject.region.click();
		drpreg.selectByVisibleText("-- Select Region --");
		 
		PrepaidPageObject.amount.clear();
		 
		 
	//select operator field has to be empty, other fields with valid input
		 testCase.log(Status.INFO, "Select Operator field is empty, other fields with valid input"); 
		 PrepaidPageObject.mobileno.sendKeys("9442513153");
		 PrepaidPageObject.region.click();
		 drpreg.selectByVisibleText("CHENNAI");

		 PrepaidPageObject.amount.sendKeys("300");
		 
		 PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		 
		 String AlertMessage = driver.switchTo().alert().getText();
		 System.out.println(AlertMessage);
		 String expectedmessage = "Select the operator name.";
		 Assert.assertEquals(AlertMessage, expectedmessage);
		 
		 Thread.sleep(1000);
		 driver.switchTo().alert().accept();
		 
		 //clean the input fields
		 
		 PrepaidPageObject.mobileno.clear();
		 PrepaidPageObject.region.click();
		 drpreg.selectByVisibleText("-- Select Region --");
		 PrepaidPageObject.amount.clear();
		
	 //Select region has to be empty, other field with valid input
	    testCase.log(Status.INFO, "Select Region field is empty, other field with valid inputs ");
		PrepaidPageObject.mobileno.sendKeys("9445642664");
	    PrepaidPageObject.operator.click();
		drpope.selectByVisibleText("Idea");
		PrepaidPageObject.amount.sendKeys("400");
		PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		String Expectedmessage = "Select the region name.";
		Assert.assertEquals(alertmessage, Expectedmessage);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear input fields
		
		PrepaidPageObject.mobileno.clear();
		PrepaidPageObject.operator.click();
		drpope.selectByVisibleText("-- Select Operator --");
		PrepaidPageObject.amount.clear();
	
	//invalid amount, other field with valid input
		testCase.log(Status.INFO, "Invalid amount,other fields with valid inputs");
		PrepaidPageObject.mobileno.sendKeys("9442356723");
		PrepaidPageObject.operator.click();
		drpope.selectByVisibleText("Idea");
		PrepaidPageObject.region.click();
		drpreg.selectByVisibleText("CHENNAI");
		PrepaidPageObject.amount.sendKeys("0");
		PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		
		String alrtmsg = driver.switchTo().alert().getText();
		System.out.println(alrtmsg);
		String expectmessage = "Enter valid amount between 1 to 50000";
		Assert.assertEquals(alrtmsg, expectmessage);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input field
		PrepaidPageObject.mobileno.clear();
		PrepaidPageObject.operator.click();
		drpope.selectByVisibleText("-- Select Operator --");
		PrepaidPageObject.region.click();
        drpreg.selectByVisibleText("-- Select Region --");
		PrepaidPageObject.amount.clear();
	 }
	 

	  @Test(description = "TestCasesID #T.C.1.1.006",priority = 8)
		 public void image() throws InterruptedException {
			 Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   PrepaidPageObject.image.click();
			  
			  PrepaidPageObject.logout.click();
			  String alrtmsg = driver.switchTo().alert().getText();
			  System.out.println(alrtmsg);
			  String expectmessage = "Are you sure want to Logout Now?";
			  Assert.assertEquals(alrtmsg, expectmessage);
			  Thread.sleep(1000);
			  driver.switchTo().alert().accept();
	  }

}
