/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：Product.java
 * 内容摘要：Product.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月18日 下午4:17:18
 * 修改记录：
 * 修改日期：2016年1月18日 下午4:17:18
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @filename 文件名称：Product.java
 * @contents 内容摘要：商品信息bean
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String descr;
	private double normalPrice;
	private double memberPrice;
	private Timestamp pdate;
	private int categoryId;
	private int sum;

	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public double getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}

	public double getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(double memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Timestamp getPdate() {
		return pdate;
	}

	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
