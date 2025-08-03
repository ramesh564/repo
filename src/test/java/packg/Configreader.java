package packg;



import java.io.FileInputStream;
import java.util.Properties;

public class Configreader {
	
	
	public class ConfigReader {

	    Properties prop;

	    public ConfigReader() throws Exception {
	        FileInputStream fis = new FileInputStream("testdata.properties");
	        prop = new Properties();
	        prop.load(fis);
	    }

	    public String getValue(String key) {
	        return prop.getProperty(key);
	    }
	}
	
	

}
