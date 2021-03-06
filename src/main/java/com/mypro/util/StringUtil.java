package com.mypro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author Yinglong Xu
 * @date 2012-2-16
 */
public class StringUtil {

	/**
	 * 首字母大写
	 * @param str
	 * @return String
	 */
	public static String capFirst(String str) {
		String firstC = str.substring(0, 1);
		return str.replaceFirst(firstC, firstC.toUpperCase());
	}
	
	/**
	 * java风格编程：驼峰式命名<br/>
	 * eg:user_name -> userName
	 * @param tableName
	 * @return String
	 */
	public static String javaStyle(String columnName) {
		String patternStr = "(_[a-z])";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(columnName);
		StringBuffer buf = new StringBuffer();
		while (matcher.find()) {
			String replaceStr = matcher.group();
			matcher.appendReplacement(buf, replaceStr.toUpperCase());
		}
		matcher.appendTail(buf);
		return buf.toString().replaceAll("_", "");
	}
	
	/**
	 * 处理：去掉前缀，驼峰式写法
	 * @param tableName
	 * @return String
	 */
	public static String javaStyleOfTableName(String tableName) {
		return StringUtil.javaStyle(tableName);
	}
	
	/**
	 * pojo class name
	 * @author xuyl
	 * @date 2013-1-7
	 * @param tableName
	 * @return
	 */
	public static String className(String tableName) {
		return capFirst(javaStyleOfTableName(tableName));
	}
}
