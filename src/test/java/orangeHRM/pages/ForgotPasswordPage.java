package orangeHRM.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.extentreport.ExtentReporter;

public class ForgotPasswordPage {
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(ForgotPasswordPage.class);
	private ExtentReporter report = new ExtentReporter();

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotpasswordbutton;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernametextbox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement resetbutton;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
	WebElement succesmsg;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void resetPasswordBtn() {
		forgotpasswordbutton.click();
		log.info("Reset Password is click");
		report.info("Reset Password is click");
	}

	public void inputUserName(String resetusername) {
		usernametextbox.sendKeys(resetusername);
		log.info("Username is: " + resetusername);
		report.info("Username is: " + resetusername);
	}

	public void resetButtonClick() {
		resetbutton.click();
		log.info("Reset Password Button is click");
		report.info("Reset Password Button is click");
	}

	public String successMassage() {
		return succesmsg.getText();
	}
}
