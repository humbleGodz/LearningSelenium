package orangeHRM.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import orangeHRM.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	LoginPage loginPage;
	Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginPage = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log.info("Running Chrome Setup.....");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		if (driver != null) {
			driver.quit();
			log.info("Chrome is shutting down.... ");
			log.info("-----------------------------");
		}
	}
}
