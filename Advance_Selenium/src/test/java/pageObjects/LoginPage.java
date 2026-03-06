package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(id = "username")
	private WebElement tbx_username;

	@FindBy(id = "inputPassword")
	private WebElement tbx_password;

	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement btn_signIn;

	@FindBy(xpath = "//a[.='Forgot password?']")
	private WebElement lnk_forgetPassword;

	@FindBy(xpath = "//a[.='Create Account']")
	private WebElement lnk_createAccount;

	public LoginPage(WebDriver driver) {
		super(driver); 
		PageFactory.initElements(driver, this); // Initialize web elements
	}

	// Action Methods

	public void enter_username(String UN) {
		tbx_username.clear();
		tbx_username.sendKeys(UN);
	}

	public void enter_password(String PW) {
		tbx_password.clear();
		tbx_password.sendKeys(PW);
	}

	public void click_signIn() {
		btn_signIn.click();
	}

	public void click_forgotPassword() {
		lnk_forgetPassword.click();
	}

	public void click_createAccount() {
		lnk_createAccount.click();
	}

}
