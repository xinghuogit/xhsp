/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：UserDAOMySql.java
 * 内容摘要：UserDAOMySql.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月17日 下午4:39:51
 * 修改记录：
 * 修改日期：2016年3月17日 下午4:39:51
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.xh.shopping.jdbc.DB;
import com.xh.shopping.model.User;

/**
 * @filename 文件名称：UserDAOMySQL.java
 * @contents 内容摘要：用户DAO MySQL
 */
public class UserDAOMySQL implements UserDAO {

	@Override
	public void addUser(User user) {

	}

	@Override
	public void isUser(User user) {

	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public void deleteUserId(int id) {

	}

	@Override
	public void loadById(int id) {

	}

	@Override
	public User loadByUserNmaePassword(String username, String password) {
		Connection conn = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from ruser where ruser.username =" + username;
		try {
			conn = DB.getConnection();
			rs = DB.executeQuery(conn, sql);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("nickname"));
				user.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return user;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public List<User> getUsers(int pageNo, int pageSize) {
		return null;
	}

}
