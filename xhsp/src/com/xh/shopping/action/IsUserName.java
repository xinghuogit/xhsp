/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：IsUserName.java
 * 内容摘要：IsUserName.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月18日 上午10:11:51
 * 修改记录：
 * 修改日期：2016年3月18日 上午10:11:51
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.shopping.util.JSONUtil;

/**
 * @filename 文件名称：IsUserName.java
 * @contents 内容摘要：
 */
public class IsUserName extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSONUtil.getInstance().getJSON0002("非法操作,请使用POST请求"));
		System.out.println("非法操作,请使用POST请求");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
