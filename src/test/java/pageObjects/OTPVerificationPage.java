package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OTPVerificationPage extends BasePage {

	public OTPVerificationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[1]")
	private WebElement txtFirstOTPField;
	@FindBy(xpath = "//input[2]")
	private WebElement txtSecondOTPField;
	@FindBy(xpath = "//input[3]")
	private WebElement txtThirdOTPField;
	@FindBy(xpath = "//input[4]")
	private WebElement txtFourthOTPField;
	@FindBy(xpath = "//input[5]")
	private WebElement txtFifthOTPField;
	@FindBy(xpath = "//input[6]")
	private WebElement txtSixthOTPField;
	@FindBy(xpath = "//button[.='Verify & Continue']")
	private WebElement btnVerifyOTP;
	@FindBy(xpath = "//h1[.='Create New Password']")
	private WebElement msgValidation;
	
	
	public void setFirstOTP(String value) {
		txtFirstOTPField.sendKeys(value);
	}
	
	public void setSecondOTP(String value) {
		txtSecondOTPField.sendKeys(value);
	}
	
	public void setThirdOTP(String value) {
		txtThirdOTPField.sendKeys(value);
	}
	
	public void setFourthOTP(String value) {
		txtFourthOTPField.sendKeys(value);
	}
	
	public void setFifthOTP(String value) {
		txtFifthOTPField.sendKeys(value);
	}
	
	public void setSixthOTP(String value) {
		txtSixthOTPField.sendKeys(value);
	}
	
	public void submit() {
		btnVerifyOTP.click();
	}
	
	public String getValidation() {
		try {
			return msgValidation.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}

}
