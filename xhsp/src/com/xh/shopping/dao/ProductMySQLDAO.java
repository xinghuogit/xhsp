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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：ProductDAO.java
 * @contents 内容摘要：MySQL商品信息DAO
 */
public class ProductMySQLDAO implements ProductDAO {

	@Override
	public List<Product> getProducts() {
		Connection conn = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "select * from product";
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalPrice"));
				p.setMemberPrice(rs.getDouble("memberPrice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryId(rs.getInt("categoryId"));
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return products;
	}

	@Override
	public List<Product> getProducts(int pageNo, int pageSize) {
		Connection conn = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "select * from product limit " + (pageNo - 1)
					* pageSize + "," + pageSize;
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalPrice"));
				p.setMemberPrice(rs.getDouble("memberPrice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryId(rs.getInt("categoryId"));
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return products;
	}

	@Override
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		int pageCount = 0;
		try {
			conn = DB.getConnection();
			rsCount = DB.executeQuery(conn, "select count(*) from product");
			rsCount.next();
			/**
			 * 算法
			 */
			pageCount = (rsCount.getInt(1) + pageSize - 1) / pageSize;

			String sql = "select * from product limit " + (pageNo - 1)
					* pageSize + "," + pageSize;
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalPrice"));
				p.setMemberPrice(rs.getDouble("memberPrice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryId(rs.getInt("categoryId"));
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(rsCount);
			DB.close(conn);
		}
		return pageCount;
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
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?)";
			ps = DB.getPStatement(conn, sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescr());
			ps.setDouble(3, p.getNormalPrice());
			ps.setDouble(4, p.getMemberPrice());
			ps.setTimestamp(5, p.getPdate());
			ps.setInt(6, p.getCategoryId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DB.close(ps);
			DB.close(conn);
		}
		return true;
	}
}
