package orangeHRM.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.extentreport.ExtentReporter;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "username")
	WebElement userNameTextbox;

	@FindBy(name = "password")
	WebElement passwordTexboxElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtnElement;

	Logger log = LogManager.getLogger(LoginPage.class);
	ExtentReporter report = new ExtentReporter();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void userNameInput(String userName) {
		userNameTextbox.sendKeys(userName);
		log.info("The Username is: " + userName);
		report.info("The Username is:" + userName);
	}

	public void passwordInput(String password) {
		passwordTexboxElement.sendKeys(password);
		log.info("The Password is: " + password);
		report.info("The Password is: " + password);
	}

	public void loginClick() {
		loginBtnElement.click();
		log.info("The Login Button is Click");
		report.info("The Login Button is Click");
	}

	public void loginSuccessMsg() {
		log.info("The Login is Success proceeding in Valid Logout Test");
		report.info("The Login is Success proceeding in Valid Logout Test");
	}
}
