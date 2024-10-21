package orangeHRM.initializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	protected Logger log = LogManager.getLogger(base.class);

	public void initializerDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome is starting.....");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox is starting.....");
		}
	}

	public void driverquit() {
		if (driver != null) {
			driver.quit();
			log.info("Driver is shutting down.....");
		}
	}
}
