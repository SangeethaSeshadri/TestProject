package mobileprepaid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testNG.BaseClass;

public class MobilePrepaidModule extends BaseClass {
	
	        //SignButton on top left(MenuBar)
			@Test(description = "TestCasesID #T.C.1.1.002",priority = 1)
			public void Signin() throws InterruptedException 
		  {
				//pause the execution for 2 seconds
				Thread.sleep(2000);
				
				//click the SIGN IN button
				driver.findElement(By.linkText("SIGN IN")).click();
				
		  }
	
	       //Check SignIn Button
	       @Test(description="TestCasesID #T.C.1.1.003,TestCasesID #T.C.1.1.005",priority = 2)
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
	 
 
	   //Check (recharge - Prepaid Module) with SignIn
	   @Test(description="TesctCasesID #T.C.1.2.001",priority = 3)
	   public void Prepaid() throws InterruptedException {
		 
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Click on "Mobile" - present on navigate bar(top left)
		 WebElement mobile = driver.findElement(By.linkText("MOBILE"));
		 mobile.click();
		 
		 String actualtext = driver.findElement(By.id("recharge_form_heading")).getText();
		 System.out.println(actualtext);
		 String expectedtext = "Recharge Now";
		 Assert.assertEquals(actualtext, expectedtext);
		 
		 driver.findElement(By.xpath("//label[contains(text(),'Prepaid')]"));
		 
	 }
	 
	   //Check with User Valid inputs
       @Test(description="TestCasesID #T.C.1.2.002",priority = 4)
       public void prepaidValidInputs() throws InterruptedException
     {
   	     WebElement mobileno = driver.findElement(By.id("mobile_no"));
		 mobileno.sendKeys("9442513153");
		 
		 WebElement operator = driver.findElement(By.id("operator_name"));
		 operator.click();
		 Select drpope = new Select(driver.findElement(By.name("operator_name")));
		 drpope.selectByVisibleText("Idea");
		 
		 WebElement region = driver.findElement(By.id("region_name"));
		 region.click();
		 Select drpreg = new Select(driver.findElement(By.name("region_name")));
		 drpreg.selectByVisibleText("CHENNAI");
		 
	     WebElement amount = driver.findElement(By.id("recharge_amount"));
		 amount.sendKeys("100");
		 
	 }
	 
       //Check browse plan link
	   @Test(description="TestCasesID #T.C.1.2.003",priority = 5)
	   public void browserplan() throws InterruptedException
	 {
		 
		 //Click on browserplan Link
		 Thread.sleep(2000);
	     WebElement plan = driver.findElement(By.xpath("//a[@id='browse_plan']"));
		 plan.click();
		 
		 //Click on Plantype dropdown
		 Thread.sleep(2000);
		 WebElement plans = driver.findElement(By.id("plan_type"));
	     plans.click();
	     Thread.sleep(1000);
		 Select drpplan = new Select(driver.findElement(By.xpath("//select[@id='plan_type']")));
		 drpplan.selectByVisibleText("Special Tariff");
		
		 //Close Browserplan popup
		 Thread.sleep(1000);
		 WebElement browser = driver.findElement(By.xpath("//body/div[@id='ajax-prepaid-plans']/div[1]/div[1]/div[1]/button[1]"));
		 browser.click();

	 }
	 
	   //Check recharge Button
	   @Test(description="TestCasesID #T.C.1.2.004",priority = 6)
	   public void rechargenowButton() throws InterruptedException
	 {
		 //Click on "recharge" button
		 Thread.sleep(1000);
		 WebElement recharge = driver.findElement(By.cssSelector("#recharge_submit_button"));
		 recharge.sendKeys(Keys.ENTER);
		 
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
		 WebElement mobile = driver.findElement(By.linkText("MOBILE"));
		 mobile.click();
		 
		 //Check with invalid user details - with signin
		 //Invalid mobile number, other fields with valid input
		 
		 WebElement mobileno = driver.findElement(By.id("mobile_no"));
		 mobileno.sendKeys("944564217");
		 
		 WebElement operator = driver.findElement(By.id("operator_name"));
         operator.click();
		 Select drpope = new Select(driver.findElement(By.name("operator_name")));
		 drpope.selectByVisibleText("Idea");
		 
		 WebElement region = driver.findElement(By.id("region_name"));
		 region.click();
		 Select drpreg = new Select(driver.findElement(By.name("region_name")));
		 drpreg.selectByVisibleText("CHENNAI");
		 
		 WebElement amount = driver.findElement(By.id("recharge_amount"));
		 amount.sendKeys("100");
		 
		 Thread.sleep(1000);
		 WebElement recharge = driver.findElement(By.cssSelector("#recharge_submit_button"));
		 recharge.sendKeys(Keys.ENTER);
		 
		 String alertMessage = driver.switchTo().alert().getText();
		 System.out.println(alertMessage);
		 String expectedMessage = "Enter a valid 10 digits mobile number!";
		 Assert.assertEquals(alertMessage, expectedMessage);
		 
		 Thread.sleep(2000);
		 driver.switchTo().alert().accept();
		 
		 //clear the input fields
		 
		 mobileno.clear();
		 
		 operator.click();
		 drpope.selectByVisibleText("-- Select Operator --");
		 
		 region.click();
		 drpreg.selectByVisibleText("-- Select Region --");
		 
		 amount.clear();
		 
		 
	//select operator field has to be empty, other fields with valid input
		  
		 mobileno.sendKeys("9445642173");
		 
		 region.click();
		 drpreg.selectByVisibleText("CHENNAI");

		 amount.sendKeys("200");
		 
		 recharge.sendKeys(Keys.ENTER);
		 
		 String AlertMessage = driver.switchTo().alert().getText();
		 System.out.println(AlertMessage);
		 String expectedmessage = "Select the operator name.";
		 Assert.assertEquals(AlertMessage, expectedmessage);
		 
		 Thread.sleep(1000);
		 driver.switchTo().alert().accept();
		 
		 //clean the input fields
		 
		 mobileno.clear();
		  
		 region.click();
		 drpreg.selectByVisibleText("-- Select Region --");
		 
		 amount.clear();
	 
	 
	 //Select region has to be empty, other field with valid input
	 
	    mobileno.sendKeys("9445642664");
	 
	    operator.click();
		drpope.selectByVisibleText("Idea");
		
		amount.sendKeys("300");
		
		recharge.sendKeys(Keys.ENTER);
		
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		String Expectedmessage = "Select the region name.";
		Assert.assertEquals(alertmessage, Expectedmessage);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear input fields
		
		mobileno.clear();
		
		operator.click();
		drpope.selectByVisibleText("-- Select Operator --");
		
		amount.clear();
		
		
	//invalid amount, other field with valid input
		
		mobileno.sendKeys("8014532716");
		
		operator.click();
		drpope.selectByVisibleText("Idea");
		
		region.click();
		drpreg.selectByVisibleText("CHENNAI");
		
		amount.sendKeys("0");
		
		recharge.sendKeys(Keys.ENTER);
		
		String alrtmsg = driver.switchTo().alert().getText();
		System.out.println(alrtmsg);
		String expectmessage = "Enter valid amount between 1 to 50000";
		Assert.assertEquals(alrtmsg, expectmessage);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input field
		
		 mobileno.clear();
		 
		 operator.click();
		 drpope.selectByVisibleText("-- Select Operator --");
		 
		 region.click();
		 drpreg.selectByVisibleText("-- Select Region --");
		 
		 amount.clear();
		 
	 }
	 


}
