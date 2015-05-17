package com.dag.robot.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplit {
	private static String div = ",";

	public static List<String> stringSplit(String string) {
		String[] strings = string.split(div);
		List<String> list = Arrays.asList(strings);
		return list;
	}
}
