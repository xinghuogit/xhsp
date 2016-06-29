/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：UserDAO.java
 * 内容摘要：UserDAO.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年3月17日 下午4:25:20
 * 修改记录：
 * 修改日期：2016年3月17日 下午4:25:20
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.dao;

import java.util.List;

import com.xh.shopping.model.User;

/**
 * @filename 文件名称：UserDAO.java
 * @contents 内容摘要：UserDAO接口，以防止MySQL和Oracle以及其他关系型数据库互相变换。
 */
public interface UserDAO {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 检查用户名是否已经注册
	 * 
	 * @param user
	 */
	public void isUser(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 根据UserId删除用户
	 * 
	 * @param id
	 */
	public void deleteUserId(int id);

	/**
	 * 根据id获取某个用户
	 * 
	 * @param id
	 */
	public void loadById(int id);

	/**
	 * 验证用户名字以及密码
	 * 
	 * @param username
	 * @param password
	 */
	public User loadByUserNmaePassword(String username, String password);

	/**
	 * 获取所有用户
	 */
	public List<User> getUsers();

	/**
	 * 返回指定页码指定数量用户
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUsers(int pageNo, int pageSize);

}
