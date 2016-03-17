/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：UserMgr.java
 * 内容摘要：UserMgr.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月17日 下午4:42:51
 * 修改记录：
 * 修改日期：2016年3月17日 下午4:42:51
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.manage;

import com.xh.shopping.dao.UserDAO;
import com.xh.shopping.dao.UserDAOMySQL;
import com.xh.shopping.model.User;

/**
 * @filename 文件名称：UserMgr.java
 * @contents 内容摘要：用户信息管理 并且负责参数检测，是否为错。
 * @下面方法用动态，而不用静态主要是为了提供缓存；用空间换取时间。
 */
public class UserMgr {
	private static UserMgr um;
	UserDAO userDAO = null;

	static {
		if (um == null) {
			um = new UserMgr();
			// 要去配置文件查看是否使用哪个数据库
			um.setUserDAO(new UserDAOMySQL());
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userDAO.addUser(user);
	};

	/**
	 * 检查用户名是否已经注册
	 * 
	 * @param user
	 */
	public void isUser(User user) {
		userDAO.isUser(user);
	}

}
