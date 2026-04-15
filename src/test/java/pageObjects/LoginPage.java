package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter Email ID']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[.='Log In']")
	private WebElement btnLogin;

	@FindBy(xpath="//p[.='Select an Agent to Start']")
	private WebElement msgValidation;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void login() {
		btnLogin.click();

	}
	
	public boolean getValidaton() {
		try {
			return msgValidation.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}
