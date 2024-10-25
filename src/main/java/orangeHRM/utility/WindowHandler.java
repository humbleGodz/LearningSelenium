package orangeHRM.utility;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHandler {
	public WebDriver driver;
	protected Logger log = LogManager.getLogger(WindowHandler.class);

	public WindowHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void switchNewWinndow(String windowTitle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String window : allWindowHandles) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				log.info("Switched to window with title: " + windowTitle);
				return;
			}
		}
		log.error("Window with title " + windowTitle + " not found.");
	}

	public void switchToOriginalWindow(String originalWindowHandle) {
		driver.switchTo().window(originalWindowHandle);
		log.info("Switched back to the original window.");
	}

}
