/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：OrderMgr.java
 * 内容摘要：OrderMgr.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年7月8日 下午3:23:16
 * 修改记录：
 * 修改日期：2016年7月8日 下午3:23:16
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.manage;

import com.xh.shopping.dao.OrderDAO;
import com.xh.shopping.dao.OrderDAOMySQL;
import com.xh.shopping.model.SalesOrder;

/**
 * @filename 文件名称：OrderMgr.java
 * @contents 内容摘要：
 */
public class OrderMgr {
	private static OrderMgr om;
	OrderDAO dao = null;

	static {
		if (om == null) {
			om = new OrderMgr();
			// 配置使用哪个数据库
			om.setDao(new OrderDAOMySQL());
		}
	}

	public static OrderMgr getInstance() {
		return om;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	/**
	 * 添加的购物车商品到订单
	 * 
	 * @param salesOrder
	 * @return
	 */
	public boolean addOrder(SalesOrder so) {
		return dao.addOrder(so);
	};

}
