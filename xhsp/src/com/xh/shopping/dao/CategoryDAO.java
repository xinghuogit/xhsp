/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：CategoryDAO.java
 * 内容摘要：CategoryDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月5日 下午5:09:38
 * 修改记录：
 * 修改日期：2016年1月5日 下午5:09:38
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.Category;

/**
 * @filename 文件名称：CategoryDAO.java
 * @contents 内容摘要：CategoryDAO层 和数据库打交道
 */
public class CategoryDAO {

	/**
	 * 添加跟类别到数据库
	 * 
	 * @param category
	 */
	public static void save(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "";
			if (category.getId() == -1) {
				sql = "insert into category values (null, ?, ?, ?, ?, ?, ?)";
			} else {
				sql = "insert into category values (" + category.getId()
						+ ", ?, ?, ?, ?, ?, ?)";
			}
			ps = DB.getPStatement(conn, sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescr());
			ps.setInt(3, category.getOrderby());
			ps.setInt(4, category.getPid());
			ps.setInt(5, category.isLeaf() ? 0 : 1);
			ps.setInt(6, category.getGrads());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(ps);
			DB.close(conn);
		}
	}

	/**
	 * 添加子类别到数据库
	 * 
	 * @param name
	 *            类别名称
	 * @param descr
	 *            备注
	 * @param orderby
	 *            排序
	 * @param pid
	 *            父id
	 */
	public static void addChild(String name, String descr, int orderby, int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();

			conn.setAutoCommit(false);

			// 获取父类别等级，+1等于当前子类别等级
			rs = DB.executeQuery(conn, "select * from category where id = "
					+ pid);
			rs.next();
			int grade = rs.getInt("grade");
			// 存储子类别
			String sql = "insert into category values (null, ?, ?, ?, ?, ?, ?)";
			ps = DB.getPStatement(conn, sql);
			ps.setString(1, name);
			ps.setString(2, descr);
			ps.setInt(3, orderby);
			ps.setInt(4, pid);
			ps.setInt(5, 0);
			ps.setInt(6, grade + 1);
			ps.executeUpdate();

			// 更新根类别叶子节点为false
			DB.executeUpdata(conn, "update category set isleaf = 1 where id ="
					+ pid);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DB.close(ps);
			DB.close(rs);
			DB.close(conn);
		}
	}

	/**
	 * 递归获取类别数据
	 * 
	 * @param categories
	 *            所有类别的list
	 */
	public static void getCategories(List<Category> categories, int id) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			String sql = "select * from category where pid = " + id;
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescr(rs.getString("descr"));
				category.setOrderby(rs.getInt("orderby"));
				category.setPid(rs.getInt("pid"));
				category.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				category.setGrads(rs.getInt("grade"));
				categories.add(category);
				if (!category.isLeaf()) {
					getCategories(categories, category.getId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
	}

	/**
	 * 根据某一个类别ID 获取类别信息
	 * 
	 * @param id
	 * @return
	 */
	public static Category loadById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		Category category = null;
		try {
			conn = DB.getConnection();
			rs = DB.executeQuery(conn, "select * from category where id = "
					+ id);
			if (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescr(rs.getString("descr"));
				category.setOrderby(rs.getInt("orderby"));
				category.setPid(rs.getInt("pid"));
				category.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				category.setGrads(rs.getInt("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return category;
	}

}
