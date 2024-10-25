package orangeHRM.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.constant.Constants;
import orangeHRM.pages.ForgotPasswordPage;
import orangeHRM.setup.Setup;
import orangeHRM.utility.TestDataProperties;

public class ForgotPasswordTest extends Setup{
	
	private ForgotPasswordPage forgot;
	
	@Test
	public void ForgotPassword() throws IOException {
		forgot = new ForgotPasswordPage(driver);
		forgot.resetPasswordBtn();
		forgot.inputUserName(TestDataProperties.propertiesUtility("resetusername"));
		forgot.resetButtonClick();
		String expectedMsg = Constants.EXPECTED_MSG;
		String actualMsg = forgot.successMassage();
		Assert.assertEquals(actualMsg, expectedMsg);
		
		}
	}

