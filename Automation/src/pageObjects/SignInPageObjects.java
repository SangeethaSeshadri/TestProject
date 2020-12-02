package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageObjects {
	
	
	@FindBy(linkText="SIGN IN")
	public static WebElement signin;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	public static WebElement signinpopup;
	
	@FindBy(id="name")
	public static WebElement name;
	
	@FindBy(id="phone")
	public static WebElement mobile;
	
	@FindBy(id="email")
	public static WebElement emailId;
	
	@FindBy(id="password_signup")
	public static WebElement password;
	
	@FindBy(id="confirm-pass")
	public static WebElement retypepass;
	
	@FindBy(id="sign_up_button")
	public static WebElement signup;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	public static WebElement forgetpass;
	
	@FindBy(id="reset_pwd_button")
	public static WebElement forgetpassbutton;
	
	@FindBy(id="email-form1")
	public static WebElement emailid;
	
	@FindBy(linkText="Sign In")
	public static WebElement signIn;
	
	@FindBy(id="email-form")
	public static WebElement email;
	
	@FindBy(id="pass-form")
	public static WebElement pass;

	@FindBy(id="sign_in_button")
	public static WebElement SignInbutton;	
	
}
