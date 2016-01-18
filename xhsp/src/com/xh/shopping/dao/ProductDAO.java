/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ProductDAO.java
 * 内容摘要：ProductDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月18日 下午5:10:27
 * 修改记录：
 * 修改日期：2016年1月18日 下午5:10:27
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.util.Date;
import java.util.List;

import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：ProductDAO.java
 * @contents 内容摘要：ProductDAO接口，以防止MySQL和Oracle以及其他关系型数据库互相变换。
 */
public interface ProductDAO {
	/**
	 * 返回全部商品全部列表数据
	 * 
	 * @return
	 */
	public List<Product> getProducts();

	/**
	 * 返回指定页码指定数量商品列表数据
	 * 
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return
	 */
	public List<Product> getProducts(int pageNo, int pageSize);

	/**
	 * 搜索商品
	 * 
	 * @param categoryId
	 *            商品类型ID
	 * @param name
	 *            商品名字
	 * @param descr
	 *            商品描述
	 * @param lowNormalPrice
	 *            商品正常价格（低价格）
	 * @param highNormalPrice
	 *            商品正常价格（高价格）
	 * @param lowMemberPrice
	 *            商品会员价格（低价格）
	 * @param highMemberPrice
	 *            商品会员价格（高价格）
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return
	 */
	public List<Product> searchProducts(int[] categoryId, String name,
			String descr, double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize);

	/**
	 * 删除商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public boolean deleteProductByCategoryId(int categoryId);

	/**
	 * 删除多个商品
	 * 
	 * @param idArray
	 * @return
	 */
	public boolean deleteProductByCategoryId(int[] idArray);

	/**
	 * 更新一个商品
	 * 
	 * @param p
	 * @return
	 */
	public boolean updateProduct(Product p);
	
	/**
	 * 添加一个商品
	 * @param p
	 * @return
	 */
	public boolean addProduct(Product p);
}
