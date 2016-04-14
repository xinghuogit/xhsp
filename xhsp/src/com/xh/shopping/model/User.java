/*************************************************************************************************
 * @版权所有 (C)2015,  星火工作室
 * 
 * @文件名称：User.java
 * @内容摘要：用户bean
 * @当前版本： TODO
 * @作        者： 李加蒙
 * @完成日期：2015年9月20日 下午6:25:05
 * @修改记录：
 * @修改日期：2015年9月20日 下午6:25:05
 * @版   本  号：
 * @修   改  人：
 * @修改内容：
 ************************************************************************************************/

package com.xh.shopping.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xh.shopping.jdbc.DB;

/**
 * @filename 文件名称：User.java
 * @contents 内容摘要：用户注册bean
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet rs;

	private int id;
	private String username;
	private String password;
	private String phone;
	private String nickname;
	private String addr;
	private Date rdate;
	private Date cpdate;
	private String auth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getName() {
		return nickname;
	}

	public void setName(String name) {
		this.nickname = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Date getCpdate() {
		return cpdate;
	}

	public void setCpdate(Date cpdate) {
		this.cpdate = cpdate;
	}

	public void save() throws Exception {
		try {
			connection = DB.getConnection();
			String sql = "insert into ruser values (null, ?, ?, ?, ?, ?, ?, ?)";
			pStatement = DB.getPStatement(connection, sql);
			pStatement.setString(1, getUsername());
			pStatement.setString(2, getPassword());
			pStatement.setString(3, getPhone());
			pStatement.setString(4, getName());
			pStatement.setString(5, getAddr());
			pStatement.setTimestamp(6, new Timestamp(getRdate().getTime()));
			pStatement.setTimestamp(7, new Timestamp(getCpdate().getTime()));
			pStatement.executeUpdate();
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(pStatement);
			DB.close(connection);
		}

		// try {
		// pStatement.setString(1, getUsername());
		// pStatement.setString(2, getPassword());
		// pStatement.setString(3, getPhone());
		// pStatement.setString(4, getName());
		// pStatement.setString(5, getAddr());
		// pStatement.setTimestamp(6, new Timestamp(getRdate().getTime()));
		// pStatement.setTimestamp(7, new Timestamp(getCpdate().getTime()));
		// pStatement.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// DB.close(pStatement);
		// DB.close(connection);
	}

	public boolean getUserName(String username) throws Exception {
		try {
			String sql = "select * from ruser";
			connection = (Connection) DB.getConnection();
			rs = DB.executeQuery(connection, sql);
			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					return false;
				}
			}
			return true;
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(rs);
			DB.close(connection);
		}
	}

	public List<User> getUser() throws Exception {
		try {
			List<User> users = new ArrayList<User>();
			String sql = "select * from ruser";
			connection = (Connection) DB.getConnection();
			rs = DB.executeQuery(connection, sql);
			while (rs.next()) {
				User user = new User();
				user.setId(Integer.valueOf(rs.getString("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			return users;
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(rs);
			DB.close(connection);
		}
	}

}
