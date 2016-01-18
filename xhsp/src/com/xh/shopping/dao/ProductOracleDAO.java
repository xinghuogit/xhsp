/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ProductOracleDAO.java
 * 内容摘要：ProductOracleDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月18日 下午5:22:01
 * 修改记录：
 * 修改日期：2016年1月18日 下午5:22:01
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.util.Date;
import java.util.List;

import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：ProductOracleDAO.java
 * @contents 内容摘要：Oracle商品信息DAO
 */
public class ProductOracleDAO implements ProductDAO {

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProducts(int[] categoryId, String name,
			String descr, double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProductByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductByCategoryId(int[] idArray) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

}
