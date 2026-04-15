package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetPasswordPage extends BasePage {
	public SetPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Create Password']")
	private WebElement txtCreatePassword;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement txtConfirmPassword;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement btnSubmit;
	@FindBy(xpath="//button[.='Let’s get started']")
	private WebElement msgValidation;

	public void setCreatePassword(String password) {
		txtCreatePassword.sendKeys(password);

	}

	public void setConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void submit() {
		btnSubmit.click();
	}
	
	public String getValidation() {
		try {
			return msgValidation.getText();
		}catch(Exception e){
			return e.getMessage();
		}
	}

}
