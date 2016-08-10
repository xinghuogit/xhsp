/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：OrderDAO.java
 * 内容摘要：OrderDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年7月8日 下午3:23:37
 * 修改记录：
 * 修改日期：2016年7月8日 下午3:23:37
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.util.List;

import com.xh.shopping.model.SalesOrder;

/**
 * @filename 文件名称：OrderDAO.java
 * @contents 内容摘要：
 */
public interface OrderDAO {
	/**
	 * 添加的购物车商品到订单
	 * 
	 * @param salesOrder
	 * @return
	 */
	public boolean addOrder(SalesOrder so);

	/**
	 * 返回全部交易列表数据
	 * 
	 * @return
	 */
	public List<SalesOrder> getSOS();

	/**
	 * 返回指定页码指定数量交易列表数据
	 * 
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return
	 */
	public List<SalesOrder> getSOS(int pageNo, int pageSize);

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
			boolean lazy);

	/**
	 * 返回交易详信息
	 * 
	 * @param so
	 *            存入交易详细信息
	 * @return
	 */
	public int getSalesItem(SalesOrder so);
}
