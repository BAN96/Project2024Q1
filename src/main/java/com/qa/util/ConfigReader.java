package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private  Properties properties;
	public  Properties init_Properties() {
		properties=new Properties();
		try {
			
			FileInputStream configFileFis = new FileInputStream(".\\src\\test\\resources\\config.properties");
			properties.load(configFileFis);
			
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
