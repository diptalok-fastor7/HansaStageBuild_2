package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_002_AccountLoginTest extends BaseClass {
    @Test (groups={"Regression","Master"})
	public void logInTest() {

		logger.info("Started TC_002_AccountLoginTest");
		try {

			RegistrationPage rp = new RegistrationPage(driver);
			rp.clickLoginCTA();
			LoginPage lp = new LoginPage(driver);
			String Email = prop.getProperty("email");
			String Password = prop.getProperty("password");
			lp.setEmail(Email);
			lp.setPassword(Password);
			lp.login();
			
			logger.info("login successfull");
			boolean welcometxt = lp.getValidaton();
			
			Assert.assertTrue(welcometxt);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finshied TC_002_AccountLoginTest");

	}

}
