package orangeHRM.runner;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import orangeHRM.pages.HomePage;
import orangeHRM.pages.LoginPage;
import orangeHRM.setup.Setup;
import orangeHRM.utility.TestDataProperties;

public class LogoutTest extends Setup {

	// @Test(priority = 1)
	@BeforeClass
	public void LoginSuccess() throws EncryptedDocumentException, IOException, InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.userNameInput(TestDataProperties.propertiesUtility("username"));
		loginPage.passwordInput(TestDataProperties.propertiesUtility("password"));
		loginPage.loginClick();
		loginPage.loginSuccessMsg();
	}

	@Test // (dependsOnMethods = "LoginSuccess")
	public void ValidLogout() {

		HomePage homepage = new HomePage(driver);
		homepage.LogoutBtn();
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);

	}
}