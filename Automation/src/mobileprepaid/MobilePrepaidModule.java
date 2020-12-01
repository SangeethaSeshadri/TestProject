package mobileprepaid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PrepaidPageObject;
import testNG.BaseClass;

public class MobilePrepaidModule extends BaseClass {
	
	   //SignButton on top left(MenuBar)
       @Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
	   public void Signin() throws InterruptedException 
		  {
				//pause the execution for 2 seconds
				Thread.sleep(2000);
				
				PageFactory.initElements(driver, PrepaidPageObject.class);
				//click the SIGN IN button
				PrepaidPageObject.signin.click();			
		  }
	
	   //Check SignIn Button
	   @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
	   public void SignInButton() throws InterruptedException 
	    {  
	      Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  PrepaidPageObject.email.sendKeys("sa@gmail.com"); 
          PrepaidPageObject.pass.sendKeys("shanthi123");
          PrepaidPageObject.SignInbutton.click();	 
        }
	  
 
	   //Check (recharge - Prepaid Module) with SignIn
	   @Test(description="TesctCasesID #T.C.1.2.001",priority = 3)
	   public void Prepaid() throws InterruptedException 
	   {
		 
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Click on "Mobile" - present on navigate bar(top left)
		 PrepaidPageObject.mobile.click();
		 
		 String actualtext = driver.findElement(By.id("recharge_form_heading")).getText();
		 System.out.println(actualtext);
		 String expectedtext = "Recharge Now";
		 Assert.assertEquals(actualtext, expectedtext);	 
		
	   }
	 
	  //Check with User Valid inputs
      @Test(description="TestCasesID #T.C.1.2.002",priority = 4)
      public void prepaidValidInputs() throws InterruptedException
       {
   	     PrepaidPageObject.mobileno.sendKeys("8904321238");
		  
		 PrepaidPageObject.operator.click();
		 Select drpope = new Select(PrepaidPageObject.drpop);
		 drpope.selectByVisibleText("Idea");
		 
		 PrepaidPageObject.region.click();
		 Select drpreg = new Select(PrepaidPageObject.drpre);
		 drpreg.selectByVisibleText("CHENNAI");
		 
	     PrepaidPageObject.amount.sendKeys("100");
		 
	  }
	 
    //Check browse plan link
	@Test(description="TestCasesID #T.C.1.2.003",priority = 5)
	public void browserplan() throws InterruptedException
	 {
		 
		 //Click on browserplan Link
		 Thread.sleep(2000);
	     PrepaidPageObject.plan.click();
		 
		 //Click on Plantype dropdown
		 Thread.sleep(2000);
		 PrepaidPageObject.plans.click();
	     Thread.sleep(1000);
		 Select drpplan = new Select(PrepaidPageObject.drpplans);
		 drpplan.selectByVisibleText("Special Tariff");
		
		 //Close Browserplan popup
		 Thread.sleep(1000);
		 PrepaidPageObject.browser.click();

	  }
	 
	//Check recharge Button
	@Test(description="TestCasesID #T.C.1.2.004",priority = 6)
	public void rechargenowButton() throws InterruptedException
	 {
		 //Click on "recharge" button
		 Thread.sleep(1000);
		 PrepaidPageObject.rechargebutton.sendKeys(Keys.ENTER);
		 
		 String actualtext = driver.findElement(By.xpath("//h3[contains(text(),'Recharge Amount Information')]")).getText();
         System.out.println(actualtext);
         String expectedtext ="Recharge Amount Information";
         Assert.assertEquals(actualtext, expectedtext);
	  }
	 
	 
	  //Negative Scenarios for prepaid 
	  @Test(description="TestCasesID #T.C.1.2.005, #T.C.1.2.006, #T.C.1.2.007, #T.C.1.2.008",priority = 7)
	  public void PrepaidNegativeScenarios() throws InterruptedException {
	 	 
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 PrepaidPageObject.mobile.click();
		 
		 //Check with invalid user details - with signin
		 //Invalid mobile number, other fields with valid input
		 
		 PrepaidPageObject.mobileno.sendKeys("944253613");
		 
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
	 


}
