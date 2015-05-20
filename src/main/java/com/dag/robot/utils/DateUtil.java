package com.dag.robot.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * @param string yyyy年mm月dd日
	 * @return
	 * @throws ParseException 
	 */
	public static Date toDate(String string, String dateFormat) throws ParseException{
		DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
		Date date = dateFormat1.parse(string);
		return date;
	}
	
}
