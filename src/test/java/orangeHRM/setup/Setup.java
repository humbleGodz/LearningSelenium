package orangeHRM.setup;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import orangeHRM.initializer.base;
import orangeHRM.utility.TestDataProperties;

public class Setup extends base {

	@BeforeClass
	public void setup() throws IOException {
		String browser = TestDataProperties.globalpropertiesUtility("browser");
		initializerDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(TestDataProperties.globalpropertiesUtility("website"));

	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driverquit();
	}
}
