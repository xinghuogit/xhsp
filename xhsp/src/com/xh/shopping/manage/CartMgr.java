/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：CartMgr.java
 * 内容摘要：CartMgr.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年6月29日 上午10:50:05
 * 修改记录：
 * 修改日期：2016年6月29日 上午10:50:05
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.manage;

import java.util.List;

import com.xh.shopping.dao.CartDAO;
import com.xh.shopping.dao.CartDAOMySql;
import com.xh.shopping.model.Cart;

/**
 * @filename 文件名称：CartMgr.java
 * @contents 内容摘要：购物车信息管理 并且负责参数检测，是否为错。
 * @下面方法用动态，而不用静态主要是为了提供缓存；用空间换取时间。
 */
public class CartMgr {
	private static CartMgr cm;
	CartDAO dao = null;

	static {
		if (cm == null) {
			cm = new CartMgr();
			// 配置使用哪个数据库
			cm.setDao(new CartDAOMySql());
		}
	}

	public static CartMgr getInstance() {
		return cm;
	}

	public CartDAO getDao() {
		return dao;
	}

	public void setDao(CartDAO dao) {
		this.dao = dao;
	}

	/**
	 * 添加一个商品到购物车
	 * 
	 * @param p
	 * @return
	 */
	public boolean addCart(Cart cart) {
		return dao.addCart(cart);
	}

	/**
	 * 根据用户id获取该用户购物车商品的信息
	 * 
	 * @param userid
	 * @return
	 */
	public List<Cart> getCarts(int userid) {
		return dao.getCarts(userid);
	}

	/**
	 * 更新一个购物车信息商品
	 * 
	 * @param cart
	 * @return
	 */
	public boolean updateCart(Cart cart) {
		return dao.updateCart(cart);
	}

	public boolean updateCarts(List<Cart> carts, int state) {
		return dao.updateCart(carts, state);
	}

	public double getTotalPrice(List<Cart> carts) {
		if (carts == null || carts.size() <= 0) {
			return 0;
		}
		double value = 0;
		for (int i = 0; i < carts.size(); i++) {
			value = +carts.get(i).getMemberTotalPrice();
		}
		value = Math.round(value * 100) / 100;
		return value;
	}

	/**
	 * 删除多个购物车项目
	 * 
	 * @param carts
	 * @return
	 */
	public boolean deleteCarts(List<Cart> carts) {
		return dao.deleteCarts(carts);
	}
}
