
package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpringMerge {
	private static String div = ",";

	public static String stringMerge(List<String> list) {
		String string = "";
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string2 = iterator.next();
			string = string + div + string2;
		}
		string = string.substring(1, string.length());
		return string;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		System.out.println(stringMerge(list));
	}
}
