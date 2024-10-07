package orangeHRM.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.utility.TestDataExcel;
import orangeHRM.utility.TestDataProperties;

public class LoginTest extends BaseTest {

	@Test(priority = 2)
	public void ValidLogin() throws EncryptedDocumentException, IOException {
		loginPage.userNameInput(TestDataExcel.excelUtility(1, 0));
		loginPage.passwordInput(TestDataExcel.excelUtility(1, 1));
		loginPage.loginClick();
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
		log.info("Valid Login Test Case is Passed");
	}

	@Test(priority = 3)
	public void InvalidLogin() throws EncryptedDocumentException, IOException {
		loginPage.userNameInput(TestDataProperties.propertiesUtility("username"));
		loginPage.passwordInput(TestDataProperties.propertiesUtility("password"));
		loginPage.loginClick();

		Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
		log.info("Invalid Login Test Case is Passed");
	}

	@Test(priority = 4)
	public void EmptyCredentialsLogin() {
		loginPage.loginClick();

		Assert.assertTrue(driver.getPageSource().contains("Required"));
		log.info("Blank Login Test Case is Passed");
	}
}
