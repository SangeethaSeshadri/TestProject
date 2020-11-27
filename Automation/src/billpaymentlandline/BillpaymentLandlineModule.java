package billpaymentlandline;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testNG.BaseClass;

public class BillpaymentLandlineModule extends BaseClass {
	
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

	  @Test(description="TestCasesID #T.C.1.4.001, #T.C.1.4.002",priority = 3)
	    public void billpaymentdropdown() throws InterruptedException
	  {
		  Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  WebElement bill = driver.findElement(By.className("dropdown-toggle"));
		  bill.click();
			
		  WebElement land = driver.findElement(By.linkText("LANDLINE"));
		  land.click();
	  }
 
	   @Test(description="TestCasesID #T.C.1.4.003, #T.C.1.4.004",priority = 4)
	   public void LandlineBillPayment() throws InterruptedException 
	 {
		 String acttext = driver.findElement(By.xpath("//p[@id='recharge_form_heading']")).getText();
		 System.out.println(acttext);
		 String expecttext = "Landline Bill Payment";
		 Assert.assertEquals(acttext, expecttext);
		
		 //Valid input for landlineBillPayment
		 WebElement operator = driver.findElement(By.id("operator_name"));
		 operator.click();
		 Select drop = new Select(driver.findElement(By.name("operator_name")));
		 drop.selectByVisibleText("Airtel");
		
		 WebElement stdcode = driver.findElement(By.id("std_code"));
		 stdcode.sendKeys("004");
		
		 WebElement landlineno = driver.findElement(By.id("account_no"));
		 landlineno.sendKeys("27432173");
		
		 WebElement amount = driver.findElement(By.id("recharge_amount"));
		 amount.sendKeys("200");
		
		 Thread.sleep(1000);
		 WebElement recharge = driver.findElement(By.cssSelector("#recharge_submit_button"));
		 recharge.sendKeys(Keys.ENTER);
		
		 String acuttext = driver.findElement(By.xpath("//h3[contains(text(),'Recharge Amount Information')]")).getText();
		 System.out.println(acuttext);
		 String expettext = "Recharge Amount Information";
		 Assert.assertEquals(acuttext, expettext);
	  }
	
	   @Test(description="TestCasesID T.C.1.4.005, #T.C.1.4.006, #T.C.1.4.007, #T.C.1.4.008",priority = 5)
	   public void LandlineNegativeScenarios() throws InterruptedException 
	   {
		
		WebElement bill = driver.findElement(By.className("dropdown-toggle"));
		bill.click();
		
		WebElement land = driver.findElement(By.linkText("LANDLINE"));
		land.click();
		
	    //Select operator has to empty, other field with valid input
		
		WebElement stdcode = driver.findElement(By.name("std_code"));
		stdcode.sendKeys("044");
		
		WebElement landline =driver.findElement(By.name("account_no"));
		landline.sendKeys("27432173");
		
		WebElement amount = driver.findElement(By.name("amount"));
		amount.sendKeys("200");
		
		WebElement recharge = driver.findElement(By.id("recharge_submit_button"));
		recharge.sendKeys(Keys.ENTER);
		
		String Alertmessage = driver.switchTo().alert().getText();
		System.out.println(Alertmessage);
		String Expectedmessage = "Select the operator name.";
		Assert.assertEquals(Alertmessage, Expectedmessage);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear input
		
		stdcode.clear();
		
		landline.clear();
		
		amount.clear();
		
	//invalid STDCODE, other field with valid input
		
		WebElement operator = driver.findElement(By.id("operator_name"));
		operator.click();
		Select drop = new Select(driver.findElement(By.name("operator_name")));
		drop.selectByVisibleText("Airtel");
		
		stdcode.sendKeys("0");
		
		landline.sendKeys("27432173");
		
		amount.sendKeys("200");
		
		recharge.sendKeys(Keys.ENTER);
		
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		String expectedmsg = "Enter valid STD Code.";
		Assert.assertEquals(alertmsg, expectedmsg);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input
		
		operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		
		stdcode.clear();
		
		landline.clear();
		
		amount.clear();
		
	  //invalid landline, other fields with valid input
		
		operator.click();
		drop.selectByVisibleText("Airtel");
		
		stdcode.sendKeys("044");
		
		landline.sendKeys("0");
		
		amount.sendKeys("200");
		
		recharge.sendKeys(Keys.ENTER);
		
		String alrtmsg = driver.switchTo().alert().getText();
		System.out.println(alrtmsg);
		String expectmsg = "Enter Valid Landline Number.";
		Assert.assertEquals(alrtmsg, expectmsg);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//Clear the input
		
		operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		
		stdcode.clear();
		
		landline.clear();
		
		amount.clear();
		
	  //invalid amount, other with valid input
		
		operator.click();
		drop.selectByVisibleText("Airtel");
		
		stdcode.sendKeys("044");
		
		landline.sendKeys("27432173");
		
		amount.sendKeys("0");
		
		recharge.sendKeys(Keys.ENTER);
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		String expectedMessage = "Enter valid amount between 1 to 50000";
		Assert.assertEquals(alertMessage, expectedMessage);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//clear the input
		
		operator.click();
		drop.selectByVisibleText("-- Select Operator --");
		
		stdcode.clear();
		
		landline.clear();
		
		amount.clear();
	
	   }

}
