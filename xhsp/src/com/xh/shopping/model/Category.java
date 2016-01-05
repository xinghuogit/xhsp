/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：Category.java
 * 内容摘要：Category.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2016年1月4日 下午7:03:33
 * 修改记录：
 * 修改日期：2016年1月4日 下午7:03:33
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.model;

/**
 * @filename 文件名称：Category.java
 * @contents 内容摘要：商品类别 bean
 */
public class Category {
	private int id;
	private String name;
	private String descr;
	private int pid; // 父id
	private boolean leaf; // 是否有子类别 0表示leaf 1表示非leaf
	private int grads;// 级别

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public int getGrads() {
		return grads;
	}

	public void setGrads(int grads) {
		this.grads = grads;
	}

}
