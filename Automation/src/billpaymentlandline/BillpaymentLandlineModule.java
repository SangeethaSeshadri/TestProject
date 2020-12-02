package billpaymentlandline;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandlinePageObject;
import testNG.BaseClass;

public class BillpaymentLandlineModule extends BaseClass {
	
	 //SignButton on top left(MenuBar)
	 @Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
	 public void Signin() throws InterruptedException 
      {
		  //pause the execution for 2 seconds
		  Thread.sleep(2000);
		  
		  PageFactory.initElements(driver, LandlinePageObject.class);
		  //click the SIGN IN button
		  LandlinePageObject.signin.click();
	  }

     //Check SignIn Button
     @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
     public void SignInButton() throws InterruptedException 
       {
           Thread.sleep(2000);
           driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
           LandlinePageObject.email.sendKeys("sa@gmail.com");
           LandlinePageObject.pass.sendKeys("shanthi123");
           LandlinePageObject.signinbutton.click();
       
       }

	 @Test(description="TestCasesID #T.C.1.4.001, #T.C.1.4.002",priority = 3)
	 public void billpaymentdropdown() throws InterruptedException
	  {
		  Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  LandlinePageObject.billpayment.click();
		  Thread.sleep(1000);
		  LandlinePageObject.landline.click();
	  }
 
	   @Test(description="TestCasesID #T.C.1.4.003, #T.C.1.4.004",priority = 4)
	   public void LandlineBillPayment() throws InterruptedException 
	     {
		 String acttext = LandlinePageObject.heading.getText();
		 System.out.println(acttext);
		 String expecttext = "Landline Bill Payment";
		 Assert.assertEquals(acttext, expecttext);
		
		 //Valid input for landlineBillPayment
		 LandlinePageObject.operator.click();
		 Select drop = new Select(LandlinePageObject.drope);
		 drop.selectByVisibleText("Airtel");
		
		 LandlinePageObject.stdcode.sendKeys("004");
		 
		 LandlinePageObject.landlineno.sendKeys("27432173");
		
		 LandlinePageObject.amount.sendKeys("200");
		
		 Thread.sleep(1000);
		 LandlinePageObject.paybill.sendKeys(Keys.ENTER);
		
		 String acuttext = driver.findElement(By.xpath("//h3[contains(text(),'Recharge Amount Information')]")).getText();
		 System.out.println(acuttext);
		 String expettext = "Recharge Amount Information";
		 Assert.assertEquals(acuttext, expettext);
	  }
	
	   @Test(description="TestCasesID T.C.1.4.005, #T.C.1.4.006, #T.C.1.4.007, #T.C.1.4.008",priority = 5)
	   public void LandlineNegativeScenarios() throws InterruptedException 
	   {
		  LandlinePageObject.billpayment.click();
		  LandlinePageObject.landline.click();
		 
	    //Select operator has to empty, other field with valid input
		
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

}
