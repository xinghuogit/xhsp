/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：SalesItem.java
 * 内容摘要：SalesItem.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年8月10日 下午1:43:09
 * 修改记录：
 * 修改日期：2016年8月10日 下午1:43:09
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.model;

/**
 * @filename 文件名称：SalesItem.java
 * @contents 内容摘要：交易项目（商品）
 */
public class SalesItem {
	private int id;
	private int productid;
	private double unitprice;
	private int pcount;
	private Product product;
	private SalesOrder so;

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

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SalesOrder getSo() {
		return so;
	}

	public void setSo(SalesOrder so) {
		this.so = so;
	}
	
	public double getTotalPrice() {
		return unitprice * pcount;
	}


}
