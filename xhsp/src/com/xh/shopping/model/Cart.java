/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：Cart.java
 * 内容摘要：Cart.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月22日 下午4:06:56
 * 修改记录：
 * 修改日期：2016年1月22日 下午4:06:56
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.model;


/**
 * @filename 文件名称：Cart.java
 * @contents 内容摘要：购物车 JavaBean
 */
public class Cart {
	private int id;
	private int productid;
	private String productname;
	private double normalprice;
	private double memberprice;
	private int count;
	private int userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getNormalprice() {
		return normalprice;
	}

	public void setNormalprice(double normalprice) {
		this.normalprice = normalprice;
	}

	public double getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getNormalTotalPrice() {
		return normalprice * count;
	}

	public double getMemberTotalPrice() {
		return memberprice * count;
	}

}
