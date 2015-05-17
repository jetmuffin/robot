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
			InputStream in = new BufferedInputStream (new FileInputStream("src/main/webapps/WEB-INF/config/config.properties"));
			mProperties.load(in);
			return mProperties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
