package orangeHRM.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {

	private WebDriver driver;
	private JavascriptExecutor js;

	public JavaScript(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;

	}
	
	public void scrollIntoElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
}
