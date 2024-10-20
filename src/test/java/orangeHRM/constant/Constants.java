package orangeHRM.constant;

public abstract class Constants {
	public final static String CURRENT_DIR = System.getProperty("user.dir");
	public final static String PATH = CURRENT_DIR+ "/src/test/resources/testData/TestData.properties";
	
	// this for valid login
	public final static String EXPECTED_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	// this is for message in forgot password
	
public final static String EXPECTED_MSG =  "Reset Password link sent successfully";
}
