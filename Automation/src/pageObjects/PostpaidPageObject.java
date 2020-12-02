package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostpaidPageObject {
	
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
	
	@FindBy(xpath="//label[contains(text(),'Postpaid')]")
	public static WebElement postpaid;

	@FindBy(id="mobile_no")
	public static WebElement mobileno;
	
	@FindBy(id="operator_name")
	public static WebElement operator;
	
	@FindBy(name="operator_name")
	public static WebElement drpop;
	
	@FindBy(id="region_name")
	public static WebElement regio;
	
	@FindBy(name="region_name")
	public static WebElement drore;
	
	@FindBy(id="recharge_amount")
	public static WebElement amount;
	
	@FindBy(css="#recharge_submit_button")
	public static WebElement paybill;
	
}
