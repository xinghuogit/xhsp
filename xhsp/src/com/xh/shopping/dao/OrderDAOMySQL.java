/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：OrderDAOMySQL.java
 * 内容摘要：OrderDAOMySQL.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年7月8日 下午3:24:05
 * 修改记录：
 * 修改日期：2016年7月8日 下午3:24:05
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
import com.xh.shopping.manage.CartMgr;
import com.xh.shopping.model.Cart;
import com.xh.shopping.model.SalesOrder;

/**
 * @filename 文件名称：OrderDAOMySQL.java
 * @contents 内容摘要：
 */
public class OrderDAOMySQL implements OrderDAO {

	@SuppressWarnings("resource")
	@Override
	public boolean addOrder(SalesOrder so) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);

			String sql = "insert into salesorder values (null, ?, ?, ?, ?)";
			ps = DB.getPStatement(conn, sql, true);
			ps.setInt(1, so.getUser().getId());
			ps.setString(2, so.getAddr());
			ps.setTimestamp(3, so.getAdate());
			ps.setInt(4, 0);
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt(1);

			String sqlItem = "insert into salesitem values (null, ?, ?, ?, ?)";
			ps = DB.getPStatement(conn, sqlItem);
			List<Cart> carts = so.getCarts();
			for (int i = 0; i < carts.size(); i++) {
				ps.setInt(1, carts.get(i).getProductid());
				ps.setDouble(2, carts.get(i).getNormalprice());
				ps.setInt(3, carts.get(i).getCount());
				ps.setInt(4, key);
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.setAutoCommit(true);
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			DB.close(ps);
			DB.close(rs);
			DB.close(conn);
		}
		return true;
	}

}
