package mobilepostpaid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testNG.BaseClass;

public class MobilePostpaidModule extends BaseClass{
	
	
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
      public void SignInButton() throws InterruptedException {

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

	
	  @Test(description="TestCasesID #T.C.1.3.001, #T.C.1.3.002, #T.C.1.3.003",priority = 3)
	  public void postpaid() throws InterruptedException {
		
		  Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Click on "Mobile" - present on navigate bar(top left)
			WebElement mobiles = driver.findElement(By.linkText("MOBILE"));
			mobiles.click();
		
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  //click postpaid(radio button)
		WebElement postpaid = driver.findElement(By.xpath("//label[contains(text(),'Postpaid')]"));
		postpaid.click();
	
		String actualtext = driver.findElement(By.id("recharge_form_heading")).getText();
		System.out.println(actualtext);
		String expectedtext = "Bill Payment";
		Assert.assertEquals(actualtext, expectedtext);
		
		//Valid inputs for postpaid
		
		WebElement mobileno = driver.findElement(By.xpath("//input[@id='mobile_no']"));
		mobileno.sendKeys("9445642173");
	
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
		
		//click on Billpayment Button
		
		 WebElement paybill = driver.findElement(By.cssSelector("#recharge_submit_button"));
		 paybill.sendKeys(Keys.ENTER);
		 
		 Thread.sleep(2000);
		 WebElement mobile = driver.findElement(By.linkText("MOBILE"));
		 mobile.click();
		 
	}
 
      //Check with invalid user details - with signin
      @Test(description="TestCasesID #T.C.1.3.004, #T.C.1.3.005, #T.C.1.3.006, #T.C.1.3.007",priority = 4)
      public void postpaidNegativeScenarios() throws InterruptedException {
    	  
	     Thread.sleep(2000);
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     WebElement postpaid = driver.findElement(By.xpath("//label[contains(text(),'Postpaid')]"));
	     postpaid.click();
	
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
	  
	    WebElement recharge = driver.findElement(By.cssSelector("#recharge_submit_button"));
	    recharge.sendKeys(Keys.ENTER);
	 
	   String alertMessage = driver.switchTo().alert().getText();
	   System.out.println(alertMessage);
	   String expectedMessage = "Enter a valid 10 digits mobile number!";
	   Assert.assertEquals(alertMessage, expectedMessage);
	   Thread.sleep(2000);
	   driver.switchTo().alert().accept();
	 
	 
	  //clear the input field
	 
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
	   String ExpectedMessage = "Select the operator name.";
	   Assert.assertEquals(AlertMessage, ExpectedMessage);
	   Thread.sleep(1000);
	   driver.switchTo().alert().accept();
	 
	 //clear the input
	 
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
	   String expectedmessage = "Select the region name.";
	   Assert.assertEquals(alertmessage, expectedmessage);
		
	   Thread.sleep(1000);
	   driver.switchTo().alert().accept();
		
	  //clear the input
		
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
      String expectmsg = "Enter valid amount between 1 to 50000";
	  Assert.assertEquals(alrtmsg, expectmsg);
		
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
