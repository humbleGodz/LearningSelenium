package orangeHRM.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private WebDriver driver;
	private WebDriverWait wait;

	public Wait(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement WaitWebElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebDriverWait getWait() {
		return this.wait;
	}
}
