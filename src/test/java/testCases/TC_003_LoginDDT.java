package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AgentPage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Datadriven","Master"})
	public void login(String email, String password, String result) {

		try {
			logger.info("started TC_003_LoginDDT");
			RegistrationPage rp = new RegistrationPage(driver);
			rp.clickLoginCTA();
			LoginPage lp = new LoginPage(driver);
			AgentPage ap = new AgentPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.login();
			boolean validationtxt = lp.getValidaton();

			if (result.equalsIgnoreCase("valid")) {
				logger.info("for valid credentials");
				if (validationtxt == true) {
					logger.info("validation successfull");
					logger.info("which means login also successfull");
					Assert.assertTrue(true);
					Thread.sleep(5000);
					ap.clickProfile();
					ap.clickLogout();
					logger.info("so logout successfull");
					logger.info("test case passed");
				} else {
					logger.info("validation unsuccessfull for valid credentials");
					logger.info("which means login also unsuccessfull for valid credentials");
					logger.info("test case failed");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false);
					sa.assertAll();
					//Assert.assertTrue(false);
				}
			}

			if (result.equalsIgnoreCase("invalid")) {
				logger.info("for invalid credentials");
				if (validationtxt == false) {
					logger.info("validation unsuccessfull");
					logger.info("which means login unsuccessfull");
					logger.info("test case passed");
					Assert.assertTrue(true);
				} else {
					Thread.sleep(5000);
					ap.clickProfile();
					ap.clickLogout();
					logger.info("validation successfull even for invalid credentials");
					logger.info("which means login successfull even for invalid credentials");
					logger.info("test case failed badly");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false);
					//Assert.assertTrue(false);
					sa.assertAll();
				}
			}
			
			navigate();
			
		} catch (Exception e) {
			Assert.fail();
			logger.debug("failed test case");
		}

		logger.info("finished TC_003_LoginDDT");

	}

}
