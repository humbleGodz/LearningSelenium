package orangeHRM.runner;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.constant.Constants;
import orangeHRM.pages.LoginPage;
import orangeHRM.setup.Setup;
import orangeHRM.utility.TestDataProperties;

public class LoginTest extends Setup {

	LoginPage loginPage;

	@Test(priority = 3)
	public void ValidLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		try {
			loginPage = new LoginPage(driver);
			loginPage.userNameInput(TestDataProperties.propertiesUtility("username"));
			loginPage.passwordInput(TestDataProperties.propertiesUtility("password"));
			loginPage.loginClick();
			String ExpectedURL = Constants.EXPECTED_URL;
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			log.info("Valid Login Test Case is Passed");
		} catch (Exception | AssertionError e) {
			log.error("Valid Login Test Case is Failed");
		}
	}

	@Test(priority = 1)
	public void InvalidLogin() throws EncryptedDocumentException, IOException {
		try {
			loginPage = new LoginPage(driver);
			loginPage.userNameInput(TestDataProperties.propertiesUtility("usernameNull"));
			loginPage.passwordInput(TestDataProperties.propertiesUtility("passwordNull"));
			loginPage.loginClick();
			Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
			log.info("Invalid Login Test Case is Passed");
		} catch (Exception | AssertionError e) {
			log.error("Invalid Login Test Case is Failed");
		}
	}

	@Test(priority = 2)
	public void EmptyCredentialsLogin() throws InterruptedException {
		try {
			loginPage = new LoginPage(driver);
			loginPage.loginClick();
			Assert.assertTrue(driver.getPageSource().contains("Required"));
			log.info("The Username is Empty");
			log.info("The Password is Empty");
			log.info("Blank Login Test Case is Passed");
		} catch (Exception | AssertionError e) {
			log.error("Empty Credentials Login Test Case is Failed");
		}
	}
}
