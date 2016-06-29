/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：HeaderAuthUtil.java
 * 内容摘要：HeaderAuthUtil.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2015年12月22日 下午4:08:14
 * 修改记录：
 * 修改日期：2015年12月22日 下午4:08:14
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.util;

/**
 * @filename 文件名称：HeaderAuthUtil.java
 * @contents 内容摘要：检查头部验证信息
 */
public class HeaderAuthUtil {
	private static String[] namepwds;

	public static String getHeaderAuth(String value) {
		if (value == null) {
			return "非法操作：验证信息为空";
		}
		namepwds = value.split(":");
		try {
			String username = namepwds[0];
			String password = namepwds[1];
			if ((StringUtil.isEmpty(username))
					&& (StringUtil.isEmpty(password))) {
				return "非法操作：验证信息为空";
			} else {
				return "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "非法操作：验证信息为空";
		}
	}
}
