package Util;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DBPropertutil {
	public static Properties getConnectionProperties(String filename) {
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream(filename)) {
            prop.load(fis); 
        } catch (IOException e) {
            System.out.println("Error reading DB properties: " + e.getMessage());
        }
		return prop;
		
	}

}
