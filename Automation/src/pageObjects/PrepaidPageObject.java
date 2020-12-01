package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrepaidPageObject {
	
	@FindBy(linkText="SIGN IN")
	public static WebElement signin;
	
	@FindBy(id="email-form")
	public static WebElement email;
	
	@FindBy(id="pass-form")
	public static WebElement pass;

	@FindBy(id="sign_in_button")
	public static WebElement SignInbutton;
	
	@FindBy(linkText="MOBILE")
	public static WebElement mobile;
	
	@FindBy(id="mobile_no")
	public static WebElement mobileno;
	
	@FindBy(id="operator_name")
	public static WebElement operator;
	
	@FindBy(name="operator_name")
	public static WebElement drpop;
	
	@FindBy(id="region_name")
	public static WebElement region;
	
	@FindBy(name="region_name")
	public static WebElement drpre;
	
	@FindBy(id="recharge_amount")
	public static WebElement amount;
	
	@FindBy(xpath="//a[@id='browse_plan']")
	public static WebElement plan;
	
	@FindBy(id="plan_type")
	public static WebElement plans;
	
	@FindBy(xpath="//select[@id='plan_type']")
	public static WebElement drpplans;
	
	@FindBy(xpath="//body/div[@id='ajax-prepaid-plans']/div[1]/div[1]/div[1]/button[1]")
	public static WebElement browser;
	
	@FindBy(css="#recharge_submit_button")
	public static WebElement rechargebutton;	
	
}
