package orangeHRM.runner;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.constant.Constants;
import orangeHRM.extentreport.ExtentReporter;
import orangeHRM.pages.LoginPage;
import orangeHRM.setup.Setup;
import orangeHRM.utility.TestDataProperties;

public class LoginTest extends Setup {

	private LoginPage loginPage;

	@Test(priority = 3)
	public void ValidLogin() throws EncryptedDocumentException, IOException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.userNameInput(TestDataProperties.propertiesUtility("username"));
		loginPage.passwordInput(TestDataProperties.propertiesUtility("password"));
		loginPage.loginClick();
		String ExpectedURL = Constants.EXPECTED_URL;
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);

	}

	@Test(priority = 1)
	public void InvalidLogin() throws EncryptedDocumentException, IOException {

		loginPage = new LoginPage(driver);
		loginPage.userNameInput(TestDataProperties.propertiesUtility("usernameNull"));
		loginPage.passwordInput(TestDataProperties.propertiesUtility("passwordNull"));
		loginPage.loginClick();
		Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));

	}

	@Test(priority = 2)
	public void EmptyCredentialsLogin() throws InterruptedException {
		ExtentReporter report = new ExtentReporter();
		loginPage = new LoginPage(driver);
		loginPage.loginClick();
		Assert.assertTrue(driver.getPageSource().contains("Required"));
		log.info("The Username is Empty");
		log.info("The Password is Empty");
		report.info("The Username is Empty");
		report.info("The Password is Empty");

	}
}
