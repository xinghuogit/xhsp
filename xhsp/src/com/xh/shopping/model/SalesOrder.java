/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：SalesOrder.java
 * 内容摘要：SalesOrder.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年7月8日 下午4:05:42
 * 修改记录：
 * 修改日期：2016年7月8日 下午4:05:42
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * @filename 文件名称：SalesOrder.java
 * @contents 内容摘要：交易列表
 */
public class SalesOrder {
	private int id;
	private User user;
	private String addr;
	private Timestamp adate;
	private int state;
	private List<Cart> carts;
	private List<SalesItem> salesItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Timestamp getAdate() {
		return adate;
	}

	public void setAdate(Timestamp adate) {
		this.adate = adate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}
}
