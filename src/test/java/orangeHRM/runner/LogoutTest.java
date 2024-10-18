package orangeHRM.runner;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.pages.HomePage;
import orangeHRM.pages.LoginPage;
import orangeHRM.setup.Setup;
import orangeHRM.utility.TestDataProperties;

public class LogoutTest extends Setup {

	Logger log = LogManager.getLogger(LogoutTest.class);

	@Test(priority = 1)
	public void LoginSucces() throws EncryptedDocumentException, IOException, InterruptedException {
		try {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.userNameInput(TestDataProperties.propertiesUtility("username"));
			loginPage.passwordInput(TestDataProperties.propertiesUtility("password"));
			loginPage.loginClick();
			String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			log.info("Valid Login Test Case is Passed");
		} catch (AssertionError e) {
			log.error("Valid Login Test Case is Failed");
		}
	}

	@Test(dependsOnMethods = "LoginSucces")
	public void ValidLogout() {
		if (driver == null) {
			log.error("WebDriver is null! Initialization might have failed.");
			throw new IllegalStateException("WebDriver is not initialized.");
		}
		try {
			HomePage homepage = new HomePage(driver);
			homepage.LogoutBtn();
			String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			log.info("Valid Logout Test Case is Passed");
		} catch (AssertionError e) {
			log.error("Valid Logout Test Case is failed");
		}
	}
}