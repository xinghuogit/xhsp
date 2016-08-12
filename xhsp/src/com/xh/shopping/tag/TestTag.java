/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：TestTag.java
 * 内容摘要：TestTag.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年8月12日 下午1:44:42
 * 修改记录：
 * 修改日期：2016年8月12日 下午1:44:42
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @filename 文件名称：TestTag.java
 * @contents 内容摘要：自定义标签类
 */
public class TestTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().write("Hello word!");
	}

}
