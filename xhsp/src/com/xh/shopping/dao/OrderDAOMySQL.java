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
import java.util.ArrayList;
import java.util.List;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.manage.CartMgr;
import com.xh.shopping.model.Cart;
import com.xh.shopping.model.Category;
import com.xh.shopping.model.Product;
import com.xh.shopping.model.SalesItem;
import com.xh.shopping.model.SalesOrder;
import com.xh.shopping.model.User;

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
			System.out.println("so.getAddr():" + so.getAddr());
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

	@Override
	public SalesOrder loadById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		SalesOrder so = null;
		try {
			conn = DB.getConnection();
			String sql = "select salesorder.id, salesorder.userid, salesorder.addr, salesorder.adate, "
					+ "salesorder.state, ruser.id rId, ruser.username, ruser.phone, "
					+ "ruser.nickname, ruser.addr rAddr, ruser.rdate "
					+ "from salesorder join ruser on (salesorder.userid = ruser.id) where salesorder.id = "
					+ id;
			// left from 如果游客可以取出来
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("rId"));
				user.setUsername(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("nickname"));
				user.setAddr(rs.getString("rAddr"));
				user.setRdate(rs.getTimestamp("rdate"));

				so = new SalesOrder();
				so.setId(rs.getInt("id"));
				so.setAddr(rs.getString("addr"));
				so.setAdate(rs.getTimestamp("adate"));
				so.setState(rs.getInt("state"));
				so.setUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return so;
	}

	@Override
	public List<SalesOrder> getSOS() {
		return null;
	}

	@Override
	public List<SalesOrder> getSOS(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public int getSOS(List<SalesOrder> sos, int pageNo, int pageSize,
			boolean lazy) {
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		int pageCount = 0;
		try {
			conn = DB.getConnection();
			rsCount = DB.executeQuery(conn, "select count(*) from salesorder");
			rsCount.next();
			/**
			 * 算法
			 */
			pageCount = (rsCount.getInt(1) + pageSize - 1) / pageSize;
			String sql = "select salesorder.id, salesorder.userid, salesorder.addr, salesorder.adate, "
					+ "salesorder.state, ruser.id rId, ruser.username, ruser.phone, "
					+ "ruser.nickname, ruser.addr rAddr, ruser.rdate "
					+ "from salesorder join ruser on (salesorder.userid = ruser.id) limit "
					+ (pageNo - 1) * pageSize + "," + pageSize;
			// left from 如果游客可以取出来
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				SalesOrder so = new SalesOrder();
				so.setId(rs.getInt("id"));
				so.setAddr(rs.getString("addr"));
				so.setAdate(rs.getTimestamp("adate"));
				so.setState(rs.getInt("state"));

				User user = new User();
				user.setId(rs.getInt("rId"));
				user.setUsername(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("nickname"));
				user.setAddr(rs.getString("rAddr"));
				user.setRdate(rs.getTimestamp("rdate"));
				so.setUser(user);
				sos.add(so);
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
	public int getSalesItem(SalesOrder so) {
		Connection conn = null;
		ResultSet rs = null;
		int pageCount = 0;
		List<SalesItem> sis = new ArrayList<SalesItem>();
		try {
			conn = DB.getConnection();
			String sql = "select salesitem.id, salesitem.productid, salesitem.unitprice, salesitem.pcount, salesitem.orderid, "
					+ "product.id pId, product.name, product.descr, product.normalPrice, product.memberPrice, product.pdate, product.categoryId "
					+ "from salesitem join product on (salesitem.productid = product.id) where salesitem.orderid = "
					+ so.getId();
			rs = DB.executeQuery(conn, sql);
			// System.out.println("sql:" + sql);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("pId"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalPrice"));
				p.setMemberPrice(rs.getDouble("memberPrice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryId(rs.getInt("categoryId"));

				SalesItem si = new SalesItem();
				si.setId(rs.getInt("id"));
				si.setProductid(rs.getInt("productid"));
				si.setUnitprice(rs.getDouble("unitprice"));
				si.setPcount(rs.getInt("pcount"));
				si.setProduct(p);
				sis.add(si);
			}
			so.setSalesItems(sis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return pageCount;
	}
}
