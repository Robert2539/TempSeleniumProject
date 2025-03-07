package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	

	private static Properties prop;

	//load properties file only once
	static { // eagar initialization
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/Config.Properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties");
		} // fis null means can't find properties file
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	//get property value by key
	public static String getProperty(String key) throws Exception {
		if (prop.getProperty(key) == null) {
			throw new Exception("Property name " + key + " is not found. PLease check application.properties file");
		}
		return prop.getProperty(key).trim(); // used trim to handle even if user gave space at the end in property fine

	}
}
