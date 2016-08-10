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

import java.util.List;

import com.xh.shopping.dao.OrderDAO;
import com.xh.shopping.dao.OrderDAOMySQL;
import com.xh.shopping.model.Cart;
import com.xh.shopping.model.SalesItem;
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

	/**
	 * 返回全部交易列表数据
	 * 
	 * @return
	 */
	public List<SalesOrder> getSOS() {
		return dao.getSOS();
	}

	/**
	 * 返回指定页码指定数量交易列表数据
	 * 
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return
	 */
	public List<SalesOrder> getSOS(int pageNo, int pageSize) {
		return dao.getSOS(pageNo, pageSize);
	}

	/**
	 * 返回指定页码指定数量交易列表数据and商品页码总数and该交易的User用户信息
	 * 
	 * @param sos
	 *            交易存入到的泛型
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @param lazy
	 *            懒散 非lazy是在获取数据的时候获取User;lazy是在获取数据的时候不获取User
	 * @return 返回商品页码总数
	 */
	public int getSOS(List<SalesOrder> sos, int pageNo, int pageSize,
			boolean lazy) {
		return dao.getSOS(sos, pageNo, pageSize, lazy);
	}

	public int getSalesItem(SalesOrder so) {
		return dao.getSalesItem(so);
	}

	public double getTotalPrice(List<SalesItem> sis) {
		if (sis == null || sis.size() <= 0) {
			return 0;
		}
		double value = 0;
		for (int i = 0; i < sis.size(); i++) {
			value += sis.get(i).getTotalPrice();
			System.out.println("value:" + value);
		}
		value = Math.round(value * 100) / 100;
		return value;
	}

}
