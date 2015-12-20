package com.xh.shopping.util;

/**
 * @filename 文件名称：StringUtil.java
 * @contents 内容摘要：String工具类
 */
public class StringUtil {
	public static boolean isStringDataNull(String str) {
		return str == null || str.trim().length() == 0;
	}
}
