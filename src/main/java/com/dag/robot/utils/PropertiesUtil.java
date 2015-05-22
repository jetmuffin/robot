package com.dag.robot.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getValue(String key){
		Properties mProperties = new Properties();
		try {
			mProperties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			return mProperties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getValue("expertPageSize"));
	}
}
