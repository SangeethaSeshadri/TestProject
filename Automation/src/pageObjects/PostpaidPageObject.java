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
	public static WebElement mobiles;
	
	@FindBy(xpath="//label[contains(text(),'Postpaid')]")
	public static WebElement postpaid;
	
	@FindBy(id="recharge_form_heading")
	public static WebElement headline;

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
	
	@FindBy(css="body.cbp-spmenu-push.page-loaded:nth-child(2) header.header:nth-child(4) nav.navbar.navbar-default.navbar-fixed-top:nth-child(1) div.container-fluid div.collapse.navbar-collapse div.dropdown a:nth-child(1) > img.img-responsive.usericonimg")
	public static WebElement image;
	
	@FindBy(partialLinkText = "Logo")
	public static WebElement logout;
	
	
}
