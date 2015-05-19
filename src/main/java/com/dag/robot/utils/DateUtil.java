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
	public static Date toDate(String string) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = dateFormat.parse(string);
		return date;
	}
	
}
