package com.xh.shopping.util;

/**
 * @filename 文件名称：StringUtil.java
 * @contents 内容摘要：String工具类
 */
public class StringUtil {
	/**
	 * 检查String是否为空或者字符串长度为0
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.trim().length() == 0 || "".equals(value);
	}
}
