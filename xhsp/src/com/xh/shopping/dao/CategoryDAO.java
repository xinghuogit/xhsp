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

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.Category;

/**
 * @filename 文件名称：CategoryDAO.java
 * @contents 内容摘要：CategoryDAO层 和数据库打交道
 */
public class CategoryDAO {

	/**
	 * 保存数据
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
}
