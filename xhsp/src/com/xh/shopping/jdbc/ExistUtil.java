/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：ExistUtil.java
 * 内容摘要：ExistUtil.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2015年12月21日 下午5:20:50
 * 修改记录：
 * 修改日期：2015年12月21日 下午5:20:50
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.shopping.model.User;

/**
 * @filename 文件名称：ExistUtil.java
 * @contents 内容摘要：账号、密码是否存在工具
 */
public class ExistUtil {
	private static Connection connection;
	private static PreparedStatement pStatement;
	private static ResultSet rs;

	public static boolean isUser(String username) throws SQLException {
		try {
			String sql = "select * from ruser where username = '" + username
					+ "'";
			connection = (Connection) DB.getConnection();
			rs = DB.executeQuery(connection, sql);
			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					System.out.println("寻找到账号");
					return true;
				}
				System.out.println("还未寻找到账号");
			}
			System.out.println("没有寻找到账号");
			return false;
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(rs);
			DB.close(connection);
		}
	}

	public static boolean isPassword(String username, String password)
			throws SQLException {
		try {
			String sql = "select * from ruser where username = " + username;
			connection = (Connection) DB.getConnection();
			rs = DB.executeQuery(connection, sql);
			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					System.out.println("密码匹配正确");
					return true;
				}
				System.out.println("密码匹配不正确");
				return false;
			}
			System.out.println("没有寻找到账号");
			return false;
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(rs);
			DB.close(connection);
		}
	}

	public static User getUser(String username) throws SQLException {
		try {
			User user = new User();
			String sql = "select * from ruser where username = " + username;
			connection = (Connection) DB.getConnection();
			rs = DB.executeQuery(connection, sql);
			if (rs.next()) {
				user.setId(Integer.valueOf(rs.getString("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setName(rs.getString("nickname"));
				user.setAddr(rs.getString("addr"));
				user.setRdate(rs.getDate("rdate"));
				user.setCpdate(rs.getDate("cpdate"));
				return user;
			}
			return null;
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(rs);
			DB.close(connection);
		}

	}
}
