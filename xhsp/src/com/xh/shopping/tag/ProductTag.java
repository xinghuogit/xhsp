/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ProductTag.java
 * 内容摘要：ProductTag.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年8月12日 下午2:37:52
 * 修改记录：
 * 修改日期：2016年8月12日 下午2:37:52
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xh.shopping.manage.ProductMgr;
import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：ProductTag.java
 * @contents 内容摘要：
 */
public class ProductTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		List<Product> products = ProductMgr.getInstance().getProducts();
		for (int i = 0; i < products.size(); i++) {
			this.getJspContext().getOut()
					.write("<br>" + products.get(i).getName());
		}
	}

}
