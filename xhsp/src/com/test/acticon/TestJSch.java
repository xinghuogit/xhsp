package com.test.acticon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/*************************************************************************************************
 * 版权所有 (C)2016
 * 
 * 文件名称：TestJSch.java
 * 内容摘要：TestJSch.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016-4-14 下午2:18:52
 * 修改记录：
 * 修改日期：2016-4-14 下午2:18:52
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
/**
 * @author 创建作者LI：李加蒙
 * @filename 文件名称：TestJSch.java
 * @contents 内容摘要：
 */
public class TestJSch {

	public static void go() {
		int lport = 22;// 本地端口
		String rhost = "xhserver-li160.tenxcloud.net";// 远程MySQL服务器
		int rport = 3306;// 远程MySQL服务端口

		String user = "root";// SSH连接用户名
		String password = "li191128";// SSH连接密码
		String host = "xhserver-li160.tenxcloud.net";// SSH服务器
		int port = 57329;// SSH访问端口
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			System.out.println(session.getServerVersion());// 这里打印SSH服务器版本信息
			System.out.println("rhost:" + rhost);
			int assinged_port = session.setPortForwardingL(lport, rhost, rport);
			System.out.println("localhost:" + assinged_port + " -> " + rhost
					+ ":" + rport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sql() {
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://LocalHost:3306/xhspsql", "root", "li191128");
			st = conn.createStatement();
			String sql = "SELECT COUNT(1) FROM All";
			rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		go();
		sql();
	}

}
