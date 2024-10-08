package orangeHRM.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataProperties {
	
	public static String propertiesUtility(String Key) throws IOException {
		
		File file = new File("src/test/resources/testData/TestData.properties");
		FileReader reader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(reader);
		return (String) properties.get(Key);
	}

}
