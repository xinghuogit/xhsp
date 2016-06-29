/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：CartDAO.java
 * 内容摘要：CartDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年6月28日 下午3:46:15
 * 修改记录：
 * 修改日期：2016年6月28日 下午3:46:15
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.util.List;

import com.xh.shopping.model.Cart;

/**
 * @filename 文件名称：CartDAO.java
 * @contents 内容摘要：CartDAO接口，以防止MySQL和Oracle以及其他关系型数据库互相变换。
 */
public interface CartDAO {
	/**
	 * 添加一个商品到购物车
	 * 
	 * @param p
	 * @return
	 */
	public boolean addCart(Cart cart);

	/**
	 * 根据用户id以及商品id寻找购物车某一商品商品的信息
	 * 
	 * @param userid
	 * @param productid
	 * @return
	 */
	public Cart loadById(int userid, int productid);

	/**
	 * 更新一个购物车信息商品
	 * 
	 * @param cart
	 * @return
	 */
	public boolean updateCart(Cart cart);

	/**
	 * 根据用户id获取该用户购物车商品的信息
	 * 
	 * @param userid
	 * @return
	 */
	public List<Cart> getCarts(int userid);
}
