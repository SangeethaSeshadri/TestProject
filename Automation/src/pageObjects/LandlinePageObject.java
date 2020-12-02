package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandlinePageObject {
	
	@FindBy(linkText="SIGN IN")
	public static WebElement signin;
	
	@FindBy(id="email-form")
	public static WebElement email;
	
	@FindBy(id="pass-form")
	public static WebElement pass;
	
	@FindBy(id="sign_in_button")
	public static WebElement signinbutton;

	@FindBy(className="dropdown-toggle")
	public static WebElement billpayment;
	
	@FindBy(linkText="LANDLINE")
	public static WebElement landline;
	
	@FindBy(xpath="//p[@id='recharge_form_heading']")
	public static WebElement heading;
	
	@FindBy(id="operator_name")
	public static WebElement operator;
	
	@FindBy(name="operator_name")
	public static WebElement drope;
	
	@FindBy(id="std_code")
	public static WebElement stdcode;
	
	@FindBy(id="account_no")
	public static WebElement landlineno;
	
	@FindBy(id="recharge_amount")
	public static WebElement amount;
	
	@FindBy(css="#recharge_submit_button")
	public static WebElement paybill;
	
}
