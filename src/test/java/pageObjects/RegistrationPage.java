package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[@placeholder='Enter Your Work Email']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
	private WebElement txtPhoneNo;

	@FindBy(xpath = "//button[@role='button']")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//h2[.='Verification Code']")
	private WebElement txtVerificationMessage;

	@FindBy(xpath = "//a[.='Login']")
	private WebElement btnLogin;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNo(String phone) {
		txtPhoneNo.sendKeys(phone);
	}
	
	public void submit() {
		btnContinue.click();
	}
	
	public void clickLoginCTA() {
		btnLogin.click();
	}
	
	public String getVerificationMessage() {
		try {
			
			return txtVerificationMessage.getText();
			
		}catch(Exception e) {
			return e.getMessage();
		}
	}

}
