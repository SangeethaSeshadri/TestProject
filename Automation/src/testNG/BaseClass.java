package testNG;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;


public class BaseClass {
	
	public WebDriver driver;
	public static String browserName = null;
	public static ExtentReports extentReport;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest testCase;

	
	@BeforeTest
	public void LaunchBrowse() 
	{
		
		PropertiesFile.getProperties();
		extentReport =  new ExtentReports();
	    htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("OS","Windows10");
		extentReport.setSystemInfo("Hostname", "Test");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("User Name", "Sangeetha");
		
		
		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("Final Report");
        
		
		if(browserName.equals("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
		    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
	
		  //maxmize the browser window
          driver.manage().window().maximize();
		
          //Enter the test url
		  driver.get("https://katkada.com/");
	}
	
	 @AfterSuite
	 public void CloseBrowser() throws InterruptedException {
		 
		
		extentReport.flush();
		
		//PropertiesFile.setProperties();
		
		 
	 }

}
