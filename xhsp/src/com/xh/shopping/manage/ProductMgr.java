/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ProductMgr.java
 * 内容摘要：ProductMgr.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月18日 下午4:19:38
 * 修改记录：
 * 修改日期：2016年1月18日 下午4:19:38
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.manage;

import java.util.Date;
import java.util.List;

import com.xh.shopping.dao.ProductDAO;
import com.xh.shopping.dao.ProductMySQLDAO;
import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：ProductMgr.java
 * @contents 内容摘要：商品信息管理
 * @下面方法用动态，而不用静态主要是为了提供缓存；用空间换取时间。
 */
public class ProductMgr {
	private static ProductMgr pm = null;
	ProductDAO dao = null;

	static {
		if (pm == null) {
			pm = new ProductMgr();
			// 要去配置文件查看是否使用哪个数据库
			pm.setDao(new ProductMySQLDAO());
		}
	}

	private ProductMgr() {
	};

	public static ProductMgr getInstance() {
		return pm;
	}

	/**
	 * 返回全部商品全部列表数据
	 * 
	 * @return
	 */
	public List<Product> getProducts() {
		return dao.getProducts();
	}

	/**
	 * 返回指定页码指定数量商品列表数据
	 * 
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return
	 */
	public List<Product> getProducts(int pageNo, int pageSize) {
		return dao.getProducts(pageNo, pageSize);
	}

	/**
	 * 返回指定页码指定数量商品列表数据and商品页码总数
	 * 
	 * @param products
	 *            商品存入到的泛型
	 * @param pageNo
	 *            查询页数
	 * @param pageSize
	 *            查询数量
	 * @return 返回商品页码总数
	 */
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		return dao.getProducts(products, pageNo, pageSize);
	}

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
			Date endDate, int pageNo, int pageSize) {
		return null;
	}

	/**
	 * 删除商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public boolean deleteProductByCategoryId(int categoryId) {
		return false;
	}

	/**
	 * 删除多个商品
	 * 
	 * @param idArray
	 * @return
	 */
	public boolean deleteProductByCategoryId(int[] idArray) {
		return false;
	}

	/**
	 * 更新或者添加一个商品
	 * 
	 * @param p
	 * @return
	 */
	public boolean updateProduct(Product p) {
		return false;
	}

	/**
	 * 添加一个商品
	 * 
	 * @param p
	 * @return
	 */
	public boolean addProduct(Product p) {
		return dao.addProduct(p);
	};

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
}
