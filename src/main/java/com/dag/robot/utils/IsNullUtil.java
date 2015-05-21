package com.dag.robot.utils;

import java.util.List;

public class IsNullUtil {
	
	/**
	 * 判断list是否为空
	 * @param list
	 * @return 为空返回true,否则返回false
	 */
	public static boolean isNullList(List<?> list){
		if(list.size() == 0 || list == null)
			return true;
		return false;
	}

}
