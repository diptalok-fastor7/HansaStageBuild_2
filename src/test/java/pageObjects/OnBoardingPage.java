package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnBoardingPage extends BasePage {

	public OnBoardingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//button[.='Let’s get started']") private WebElement btnGetStarted;
	@FindBy (xpath="//input[@placeholder='Enter company name']") private WebElement txtCompanyName;
	@FindBy (xpath = "//button[@id='onboading-next-and-submit-btn']") private WebElement btnNext;
	@FindBy (xpath = "//textarea[@placeholder='Tell us about your company']") private WebElement txtCompanyDetails;
	@FindBy (xpath = "//input[@placeholder='Enter no. of hiring']") private WebElement txtAverageHiring;
	@FindBy (xpath = "//button[.='Naukri']") private WebElement txtHiringTool;
	@FindBy (xpath = "//p[.='Select an Agent to Start']") private WebElement txtValidation;
	
	
			
	public void clickGetStarted() {
		btnGetStarted.click();
	}
	
	public void companyName() throws Exception {
		txtCompanyName.sendKeys("Company Name");
	}
	
	public void companyAbout() throws Exception {
		txtCompanyDetails.sendKeys("Company details");
	}
	
	public void clickNext() {
		btnNext.click();
	}
	
	public void averageHiringDetail() {
		txtAverageHiring.sendKeys("test test");
	}
	
	public void clickHiringTool() {
		txtHiringTool.click();
	}

	public String getValidation() {
		return txtValidation.getText();
	}
}
