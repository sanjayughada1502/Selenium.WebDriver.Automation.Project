package General_Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public String getData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}
