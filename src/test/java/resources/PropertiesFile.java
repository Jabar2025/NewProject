package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties Property = new Properties(); 
	
	public static String readPropertiesFile(String input)
	{	
		String Prop = null;		
		try {                                           
			InputStream FileRead = new FileInputStream("./src/test/java/resources/config.properties");
			 Property.load(FileRead);
			 Prop = Property.getProperty(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Prop;
		
	}
	}
