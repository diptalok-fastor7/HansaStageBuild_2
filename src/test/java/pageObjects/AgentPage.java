package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgentPage extends BasePage {

	public AgentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@id='radix-_r_0_']")
	private WebElement btnProfile;

	@FindBy(xpath = "//div[.='Logout']")
	private WebElement btnLogout;
	
	public void clickProfile() {
		btnProfile.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

}
