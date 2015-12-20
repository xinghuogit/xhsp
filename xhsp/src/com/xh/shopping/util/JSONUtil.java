/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：JSONUtil.java
 * 内容摘要：JSONUtil.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2015年12月20日 下午5:56:43
 * 修改记录：
 * 修改日期：2015年12月20日 下午5:56:43
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.util;

import java.util.List;

import com.google.gson.Gson;

/**
 * @filename 文件名称：JSONUtil.java
 * @contents 内容摘要：
 */
public class JSONUtil {
	private String ret;
	private String msg;
	// private List<?> list;
	private Object body;

	private static JSONUtil jsonUtil = null;

	public static synchronized JSONUtil getInstance() {
		if (jsonUtil == null) {
			jsonUtil = new JSONUtil();
			return jsonUtil;
		}
		return jsonUtil;
	}

	private JSONUtil() {
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// public List<?> getList() {
	// return list;
	// }
	//
	// public void setList(List<?> list) {
	// this.list = list;
	// }

	public Object getObject() {
		return body;
	}

	public void setObject(Object object) {
		this.body = object;
	}

	public String getJSON(String ret, String msg, Object body) {
		setRet(ret);
		setMsg(msg);

		if (body instanceof List<?>) {

		}

		setObject(body);

		Gson json = new Gson();
		return json.toJson(this);
	}

}
