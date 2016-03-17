/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：SMSVerifyKit.java
 * 内容摘要：SMSVerifyKit.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月17日 下午5:40:13
 * 修改记录：
 * 修改日期：2016年3月17日 下午5:40:13
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.sms;


/**
 * @filename 文件名称：SMSVerifyKit.java
 * @contents 内容摘要：服务端发起验证请求验证移动端(手机)发送的短信
 */
public class SMSVerifyKit {
	private String appkey;
	private String phone;
	private String zone;
	private String code;

	/**
	 * 
	 * @param appkey
	 *            应用KEY
	 * @param phone
	 *            电话号码 xxxxxxxxx
	 * @param zone
	 *            区号 -86
	 * @param code
	 *            验证码 xx
	 */
	public SMSVerifyKit(String appkey, String phone, String zone, String code) {
		super();
		this.appkey = appkey;
		this.phone = phone;
		this.zone = zone;
		this.code = code;
	}

	/**
	 * 服务端发起验证请求验证移动端(手机)发送的短信
	 * 
	 * @return
	 * @throws Exception
	 */
	public String go() throws Exception {

		String address = "https://webapi.sms.mob.com/sms/verify";
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone)
					.addParam("zone", zone).addParam("code", code);
			client.addRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
}
