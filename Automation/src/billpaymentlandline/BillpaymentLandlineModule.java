package billpaymentlandline;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LandlinePageObject;
import testNG.BaseClass;

public class BillpaymentLandlineModule extends BaseClass {
	
	 
	 @Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
	 public void Signin() throws InterruptedException 
      {
		  testCase = extentReport.createTest("SignIn for Billpayment");
		  Thread.sleep(2000);
		  
		  PageFactory.initElements(driver, LandlinePageObject.class);
		  //click the SIGN IN button
		  LandlinePageObject.signin.click();
			testCase.log(Status.INFO, "Login Katkada Webpage");
	  }

     //Check SignIn Button
     @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
     public void SignInButton() throws InterruptedException 
       {
    	   testCase = extentReport.createTest("SignInButton");
           Thread.sleep(2000);
           driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
           LandlinePageObject.email.sendKeys("sa@gmail.com");
           testCase.log(Status.INFO, "Valid Email");
           LandlinePageObject.pass.sendKeys("shanthi123");
           testCase.log(Status.INFO, "Valid Password");
           LandlinePageObject.signinbutton.click();
           testCase.log(Status.INFO, "Checked the SignIn Button");
       
       }

	 @Test(description="TestCasesID #T.C.1.4.001, #T.C.1.4.002",priority = 3)
	 public void billpaymentdropdown() throws InterruptedException
	  {
		  testCase = extentReport.createTest("BillPayment - Landline Module");
		  Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  LandlinePageObject.billpayment.click();
		  testCase.log(Status.INFO, "Checked Billpayment Dropdown");
		  Thread.sleep(1000);
		  LandlinePageObject.landline.click();
		  testCase.log(Status.INFO, "Checked Landline Module");
	  }
 
	 @Test(description="TestCasesID #T.C.1.4.003, #T.C.1.4.004",priority = 4)
	 public void LandlineBillPayment() throws InterruptedException 
	  {
		 testCase = extentReport.createTest("Landline Positive Scenarios");
		 String acttext = LandlinePageObject.heading.getText();
		 System.out.println(acttext);
		 String expecttext = "Landline Bill Payment";
		 Assert.assertEquals(acttext, expecttext);
		 if(acttext.equals(expecttext)) {
			  testCase.log(Status.PASS, "Actual text and Expected text are equal");
		  }else {
			  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
		  }
		 
		 testCase.log(Status.INFO, "Checked with Vaild Inputs");
		 //Valid input for landlineBillPayment
		 testCase.log(Status.INFO, "Selected the Operator");
		 LandlinePageObject.operator.click();
		 Select drop = new Select(LandlinePageObject.drope);
		 drop.selectByVisibleText("Airtel");
		 
		 testCase.log(Status.INFO, "Vaild STDCode");
		 LandlinePageObject.stdcode.sendKeys("004");
		 
		 testCase.log(Status.INFO, "Vaild Landline number");
		 LandlinePageObject.landlineno.sendKeys("27432173");
		
		 testCase.log(Status.INFO, "Vaild Amount");
		 LandlinePageObject.amount.sendKeys("200");
		
		 Thread.sleep(1000);
		 LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		 testCase.log(Status.INFO, "Checked the PayBill button");
		
		 String acuttext = driver.findElement(By.xpath("//h3[contains(text(),'Recharge Amount Information')]")).getText();
		 System.out.println(acuttext);
		 String expettext = "Recharge Amount Information";
		 Assert.assertEquals(acuttext, expettext);
		 if(acuttext.equals(expettext)) {
			  testCase.log(Status.PASS, "Actual text and Expected text are equal");
		  }else {
			  testCase.log(Status.FAIL, "Actual text and Expected text are not equal");
		  }
		 
	  }
	
	   @Test(description="TestCasesID T.C.1.4.005, #T.C.1.4.006, #T.C.1.4.007, #T.C.1.4.008",priority = 5)
	   public void LandlineNegativeScenarios() throws InterruptedException 
	   {  
		  testCase = extentReport.createTest("Landline Negative Scenarios");
		  LandlinePageObject.billpayment.click();
		  LandlinePageObject.landline.click();
		 
	    //Select operator has to empty, other field with valid input
		testCase.log(Status.INFO, "Select Operator field is empty, Other field with Valid inputs");
		LandlinePageObject.stdcode.sendKeys("044");
		LandlinePageObject.landlineno.sendKeys("27432173");
		LandlinePageObject.amount.sendKeys("200");
		LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		
		String Alertmessage = driver.switchTo().alert().getText();
		System.out.println(Alertmessage);
		String Expectedmessage = "Select the operator name.";
		Assert.assertEquals(Alertmessage, Expectedmessage);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear input
		
		LandlinePageObject.stdcode.clear();
		LandlinePageObject.landlineno.clear();
		LandlinePageObject.amount.clear();
		
	//invalid STDCODE, other field with valid input
		testCase.log(Status.INFO, "Invalid STDCode Other field with Valid inputs");
		LandlinePageObject.operator.click();
		Select drop = new Select(LandlinePageObject.drope);
		drop.selectByVisibleText("Airtel");
		
		LandlinePageObject.stdcode.sendKeys("0");
		LandlinePageObject.landlineno.sendKeys("27432173");
		LandlinePageObject.amount.sendKeys("200");
		LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		String expectedmsg = "Enter valid STD Code.";
		Assert.assertEquals(alertmsg, expectedmsg);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input
		
		LandlinePageObject.operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		LandlinePageObject.stdcode.clear();
		LandlinePageObject.landlineno.clear();
		LandlinePageObject.amount.clear();
	
		
	  //invalid landline, other fields with valid input
		testCase.log(Status.INFO, "Invalid Landline Number Other field with Valid inputs");
		LandlinePageObject.operator.click();
		drop.selectByVisibleText("Airtel");
		LandlinePageObject.stdcode.sendKeys("044");
		LandlinePageObject.landlineno.sendKeys("0");
		LandlinePageObject.amount.sendKeys("200");
		LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		
		String alrtmsg = driver.switchTo().alert().getText();
		System.out.println(alrtmsg);
		String expectmsg = "Enter Valid Landline Number.";
		Assert.assertEquals(alrtmsg, expectmsg);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//Clear the input
		
		LandlinePageObject.operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		LandlinePageObject.stdcode.clear();
		LandlinePageObject.landlineno.clear();
		LandlinePageObject.amount.clear();
		
	  //invalid amount, other with valid input
		testCase.log(Status.INFO, "Invalid amount Other field with Valid inputs");
		LandlinePageObject.operator.click();
		drop.selectByVisibleText("Airtel");
		LandlinePageObject.stdcode.sendKeys("044");
		LandlinePageObject.landlineno.sendKeys("27432173");	
		LandlinePageObject.amount.sendKeys("0");
		LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		String expectedMessage = "Enter valid amount between 1 to 50000";
		Assert.assertEquals(alertMessage, expectedMessage);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input
		
		LandlinePageObject.operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		LandlinePageObject.stdcode.clear();
		LandlinePageObject.landlineno.clear();
		LandlinePageObject.amount.clear();
	
	
	   }
	   
	   @Test(description = "TestCasesID #T.C.1.1.006",priority = 6)
		 public void image() throws InterruptedException {
			 Thread.sleep(2000);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   LandlinePageObject.image.click();
			  
			   LandlinePageObject.logout.click();
			  String alrtmsg = driver.switchTo().alert().getText();
			  System.out.println(alrtmsg);
			  String expectmessage = "Are you sure want to Logout Now?";
			  Assert.assertEquals(alrtmsg, expectmessage);
			  Thread.sleep(1000);
			  driver.switchTo().alert().accept();
    }


}
