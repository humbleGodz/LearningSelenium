package orangeHRM.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	Logger log = LogManager.getLogger(HomePage.class);
	
	@FindBy (xpath = "//img[@class='oxd-userdropdown-img']")
	WebElement profile;
	
	@FindBy (linkText = "Logout")
	WebElement logout;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LogoutBtn() {
		profile.click();
		log.info("Profile is clicked");
		logout.click();
		log.info("Logout is clicked");
	}

}
