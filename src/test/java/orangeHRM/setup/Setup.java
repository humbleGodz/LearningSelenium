package orangeHRM.setup;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import orangeHRM.utility.TestDataProperties;

public class Setup {

	protected WebDriver driver;
	protected Logger log = LogManager.getLogger(Setup.class);

	@BeforeTest
	public void setup() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(TestDataProperties.propertiesUtility("website"));
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
