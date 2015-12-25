/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：SQLSTATEMENT.java
 * 内容摘要：SQLSTATEMENT.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2015年12月25日 下午6:32:12
 * 修改记录：
 * 修改日期：2015年12月25日 下午6:32:12
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @filename 文件名称：SQLSTATEMENT.java
 * @contents 内容摘要：
 */
public class SQLSTATEMENT {
	private static Connection connection;
	private static PreparedStatement statement;
	private static ResultSet rs;

	public static void changePassword(int id, String userName, String password)
			throws SQLException {
		try {
			connection = DB.getConnection();
			String sql = "update ruser set password = ? where id = ?";
			statement = DB.getPStatement(connection, sql);
			statement.setString(1, password);
			statement.setInt(2, id);
			statement.executeUpdate();
		} finally {
			System.out.println("是否异常都需关闭数据库连接");
			DB.close(connection);
			DB.close(statement);
		}
	}
}
