package com.dag.robot.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringSplitUtil {
	private static String div = ",";

	public static List<String> stringSplit(String string) {
		String[] strings = string.split(div);
		List<String> list = Arrays.asList(strings);
		return list;
	}
	
	public static List<String> stringSplit(String string, String div1) {
		String[] strings = string.split(div1);
		List<String> list = Arrays.asList(strings);
		return list;
	}
	
}
