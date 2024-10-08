package orangeHRM.setup;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup {

	protected WebDriver driver;
	protected Logger log = LogManager.getLogger(Setup.class);

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log.info("Chrome is starting.....");
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {
		if (driver != null) {
			driver.quit();
			log.info("Chrome is shutting down.... ");
		}
	}
}
