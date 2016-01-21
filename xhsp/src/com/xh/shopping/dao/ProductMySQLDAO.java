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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.Category;
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
	public int getProducts(List<Product> products, int pageNo, int pageSize,
			boolean lazy) {
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
			String sql = "select  product.id, product.name, product.descr, product.normalPrice, product.memberPrice, "
					+ "product.pdate, product.categoryId, category.id cId, category.name cName, category.descr cDescr, "
					+ "category.orderby cOrderby, category.pid cPid, category.isleaf cIsLeaf, category.grade cGrade "
					+ "from product join category on (product.categoryId = category.id) limit "
					+ (pageNo - 1) * pageSize + "," + pageSize;
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

				Category category = new Category();
				category.setId(rs.getInt("cId"));
				category.setName(rs.getString("cName"));
				category.setDescr(rs.getString("cDescr"));
				category.setOrderby(rs.getInt("cOrderby"));
				category.setPid(rs.getInt("cPid"));
				category.setLeaf(rs.getInt("cIsLeaf") == 0 ? true : false);
				category.setGrads(rs.getInt("cGrade"));
				p.setCategory(category);
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
	public List<Product> searchProducts(int[] idArray, String keyword,
			double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		Connection conn = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "select * from product where 1=1";
			String sqlparse = "";

			String strId = "";
			if (idArray != null && idArray.length > 0) {
				strId += "(";
				for (int i = 0; i < idArray.length; i++) {
					if (i < idArray.length - 1) {
						strId += idArray[i] + ",";
					} else {
						strId += idArray[i];
					}
				}
				strId += ")";
				sqlparse += " and categoryId in" + strId;
			}

			if (keyword != null && !"".equals(keyword.trim())) {
				sqlparse += " and name like '%" + keyword
						+ "%' or descr like '%" + keyword;
			}

			if (lowNormalPrice >= 0) {
				sqlparse += " and normalPrice > " + lowNormalPrice;
			}

			if (highNormalPrice > 0) {
				sqlparse += " and normalPrice < " + highNormalPrice;
			}

			if (lowMemberPrice >= 0) {
				sqlparse += " and memberPrice > " + lowMemberPrice;
			}

			if (highMemberPrice > 0) {
				sqlparse += " and memberPrice < " + highMemberPrice;
			}

			if (startDate != null) {
				sqlparse += " and pdate >= '"
						+ new SimpleDateFormat("yyyy-MM--dd").format(startDate)
						+ "'";
			}

			if (endDate != null) {
				sqlparse += " and pdate <= '"
						+ new SimpleDateFormat("yyyy-MM--dd").format(endDate)
						+ "'";
			}

			sql += sqlparse + " limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;

			System.out.println("sql:" + sql);

			// String sql = "select * from product limit " + (pageNo - 1)
			// * pageSize + "," + pageSize;
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
	public int searchProducts(List<Product> products, int[] idArray,
			String keyword, double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		int pageCount = 0;
		try {
			conn = DB.getConnection();
			String sql = "select * from product where 1=1";
			// String sqlparse = "";

			String strId = "";
			if (idArray != null && idArray.length > 0) {
				strId += "(";
				for (int i = 0; i < idArray.length; i++) {
					if (i < idArray.length - 1) {
						strId += idArray[i] + ",";
					} else {
						strId += idArray[i];
					}
				}
				strId += ")";
				sql += " and categoryId in" + strId;
			}

			if (keyword != null && !"".equals(keyword.trim())) {
				sql += " and name like '%" + keyword + "%' or descr like '%"
						+ keyword + "%'";
			}

			if (lowNormalPrice >= 0) {
				sql += " and normalPrice > " + lowNormalPrice;
			}

			if (highNormalPrice > 0) {
				sql += " and normalPrice < " + highNormalPrice;
			}

			if (lowMemberPrice >= 0) {
				sql += " and memberPrice > " + lowMemberPrice;
			}

			if (highMemberPrice > 0) {
				sql += " and memberPrice < " + highMemberPrice;
			}

			if (startDate != null) {
				sql += " and pdate >= '"
						+ new SimpleDateFormat("yyyy-MM--dd").format(startDate)
						+ "'";
			}

			if (endDate != null) {
				sql += " and pdate <= '"
						+ new SimpleDateFormat("yyyy-MM--dd").format(endDate)
						+ "'";
			}
			String sqlCount = sql.replaceFirst("select \\*", "select count(*)");

			sql += " limit " + (pageNo - 1) * pageSize + "," + pageSize;

			System.out.println("sqlCount:" + sqlCount);
			rsCount = DB.executeQuery(conn, sqlCount);
			/**
			 * 算法 页码总数
			 */
			if (rsCount.next()) {
				pageCount = (rsCount.getInt(1) + pageSize - 1) / pageSize;
			}
			;

			System.out.println("sql:" + sql);
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
		return pageCount;
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
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "update product set name=? , descr=?, normalPrice=? , memberPrice=? , pdate=? , categoryId=? where id="
					+ p.getId();
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

	@Override
	public Product loadById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		Product p = null;
		try {
			conn = DB.getConnection();
			String sql = "select product.id, product.name, product.descr, product.normalPrice, product.memberPrice, product.pdate, product.categoryId"
					+ ", category.id cId, category.name cName,category.descr cDescr, category.pid, category.isleaf, category.orderby, category.grade "
					+ "from product join category on (product.categoryId =category.id) where product.id ="
					+ id;
			rs = DB.executeQuery(conn, sql);
			if (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalPrice"));
				p.setMemberPrice(rs.getDouble("memberPrice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryId(rs.getInt("categoryId"));

				Category category = new Category();
				category.setId(rs.getInt("cId"));
				category.setName(rs.getString("cName"));
				category.setDescr(rs.getString("cDescr"));
				category.setPid(rs.getInt("pid"));
				category.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				category.setOrderby(rs.getInt("orderby"));
				category.setGrads(rs.getInt("grade"));

				p.setCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}

		return p;
	}

	// 前台展示商品
	@Override
	public List<Product> getLatestProducts(int count) {
		Connection conn = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DB.getConnection();
			String sql = "select * from product limit 0," + count;
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
}
