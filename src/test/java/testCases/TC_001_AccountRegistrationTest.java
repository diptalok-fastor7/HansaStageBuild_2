package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OTPVerificationPage;
import pageObjects.RegistrationPage;
import pageObjects.SetPasswordPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test (priority = 1, groups = {"Sanity","Master"})
	void signUpTest() {
		try {
		logger.info("Started TC_001_AccountRegistrationTest");

		RegistrationPage rp = new RegistrationPage(driver);
		rp.setUsername(nameValue());
		rp.setEmail(emailValue());
		rp.setPhoneNo("8249356074");
		rp.submit();
		logger.info("Registration done successfully");

		Assert.assertEquals(rp.getVerificationMessage(), "Verification Code");
		} catch (Exception e) {
			logger.error("signUpTest failed");
			logger.debug("debug signUpTest method logs");
		}

	}
	
	@Test (dependsOnMethods = "signUpTest", groups = {"Sanity","Master"})
	void verifcationOTPTest() {
		try {
		OTPVerificationPage otp = new OTPVerificationPage(driver);
		otp.setFirstOTP("1");
		otp.setSecondOTP("2");
		otp.setThirdOTP("3");
		otp.setFourthOTP("4");
		otp.setFifthOTP("5");
		otp.setSixthOTP("6");
		otp.submit();
		
		logger.info("Verification of OTP done successfully");
		
		Assert.assertEquals(otp.getValidation(), "Create New Password");
		}  catch (Exception e) {
			logger.error("verifcationOTPTest method failed");
			logger.debug("debug verifcationOTPTest method logs");
		}
		
	}
	
	@Test(dependsOnMethods = "verifcationOTPTest",groups = {"Sanity","Master"})
	void setPasswordTest() {
		try {
		SetPasswordPage sp = new SetPasswordPage(driver);
		
		String password = passwordValue();
		sp.setCreatePassword(password);
		sp.setConfirmPassword(password);
		sp.submit();
		
		logger.info("Password set successfully");
		
		Assert.assertEquals(sp.getValidation(), "Let’s get started");
		
		logger.info("Finished TC_001_AccountRegistrationTest");
		
		} catch (Exception e) {
			logger.error("setPasswordTest");
			logger.debug("debug setPasswordTest method logs");
		}
	}

}
