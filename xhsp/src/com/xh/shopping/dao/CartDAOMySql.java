/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：CartDAOMySql.java
 * 内容摘要：CartDAOMySql.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年6月29日 上午10:48:39
 * 修改记录：
 * 修改日期：2016年6月29日 上午10:48:39
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.Cart;
import com.xh.shopping.model.Category;
import com.xh.shopping.model.Product;

/**
 * @filename 文件名称：CartDAOMySql.java
 * @contents 内容摘要：MySQL购物车信息DAO
 */
public class CartDAOMySql implements CartDAO {

	@Override
	public boolean addCart(Cart cart) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "insert into cart values (null, ?, ?, ?, ?, ?, ?)";
			Cart c = loadById(cart.getUserid(), cart.getProductid());
			if (c != null) {
				updateCart(c);
			} else {
				ps = DB.getPStatement(conn, sql);
				ps.setInt(1, cart.getProductid());
				ps.setString(2, cart.getProductname());
				ps.setDouble(3, cart.getNormalprice());
				ps.setDouble(4, cart.getMemberprice());
				ps.setInt(5, cart.getCount());
				ps.setInt(5, cart.getUserid());
				ps.executeUpdate();
			}
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
	public Cart loadById(int userid, int productid) {
		Connection conn = null;
		ResultSet rs = null;
		Cart cart = null;
		String sql = "select * from cart where cart.userid =" + userid
				+ "and cart.productid =" + productid;
		try {
			rs = DB.executeQuery(conn, sql);
			if (rs.next()) {
				cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setProductid(rs.getInt("productid"));
				cart.setProductname(rs.getString("productname"));
				cart.setNormalprice(rs.getDouble("normalprice"));
				cart.setMemberprice(rs.getDouble("memberprice"));
				cart.setCount(rs.getInt("count"));
				cart.setUserid(rs.getInt("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return cart;
	}

	@Override
	public boolean updateCart(Cart cart) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "update cart set productname=?, normalprice=? , memberprice=? , count=? where userid ="
					+ cart.getUserid()
					+ "and productid ="
					+ cart.getProductid();
			ps = DB.getPStatement(conn, sql);
			ps.setString(1, cart.getProductname());
			ps.setDouble(2, cart.getNormalprice());
			ps.setDouble(3, cart.getMemberprice());
			ps.setInt(4, (cart.getCount() + 1));
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
