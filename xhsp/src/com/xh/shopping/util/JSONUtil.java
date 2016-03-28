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
 * @contents 内容摘要：JSON字符串
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

	/**
	 * @ret 0001 获取数据成功
	 * @param body
	 *            返回的数据
	 * @return
	 * 
	 */
	public String getJSON0001(Object body) {
		setRet("0001");
		setMsg("成功");

		setObject(body);

		Gson json = new Gson();
		return json.toJson(this);
	}

	/**
	 * @ret 0002 失败
	 * @param msg
	 *            失败的原因
	 * @return
	 */
	public String getJSON0002(String msg) {
		setRet("0002");
		setMsg(msg);

		Gson json = new Gson();
		return json.toJson(this);
	}

	/**
	 * @ret 0009 失败
	 * @param msg
	 *            失败的原因(一般都是因为数据库连接失败)
	 * @return
	 */
	public String getJSON0009(String msg) {
		setRet("0009");
		setMsg(msg);

		Gson json = new Gson();
		if (Constant.ISSQLEXCEPTION) {
			return json.toJson(this);
		} else {
			return null;
		}
	}

}
