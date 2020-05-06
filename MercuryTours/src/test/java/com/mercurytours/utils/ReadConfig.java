package com.mercurytours.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	

	public String getApplicationURL() {
		String baseURL = properties.getProperty("baseURL");
		return baseURL;
	}

	public String getUsername() {
		String username = properties.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

	public String getChromepath() {
		String chromepath = properties.getProperty("chromepath");
		if(chromepath!= null) return chromepath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");

	}

	public String getFirefoxpath() {
		String firefoxpath = properties.getProperty("firefoxpath");
		if(firefoxpath!= null) return firefoxpath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getIEpath() {
		String iepath = properties.getProperty("iepath");
		if(iepath!= null) return iepath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

}
