/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ProductDAO.java
 * 内容摘要：ProductDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月18日 下午4:17:46
 * 修改记录：
 * 修改日期：2016年1月18日 下午4:17:46
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
 * @contents 内容摘要：MySQL商品信息DAO
 */
public class ProductMySQLDAO implements ProductDAO {

	@Override
	public List<Product> getProducts() {
		return null;
	}

	@Override
	public List<Product> getProducts(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public List<Product> searchProducts(int[] categoryId, String name,
			String descr, double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		return null;
	}

	@Override
	public boolean deleteProductByCategoryId(int categoryId) {
		return false;
	}

	@Override
	public boolean deleteProductByCategoryId(int[] idArray) {
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		return false;
	}

	@Override
	public boolean addProduct(Product p) {
		return false;
	}

}
