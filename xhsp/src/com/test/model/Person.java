/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：Person.java
 * 内容摘要：Person.java
 * 当前版本：TODO
 * 作        者：李加蒙1605651971@qq.com
 * 完成日期：2015年12月17日 下午4:36:36
 * 修改记录：
 * 修改日期：2015年12月17日 下午4:36:36
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.test.model;

import java.io.Serializable;
import java.util.List;

/**
 * @filename 文件名称：Person.java
 * @contents 内容摘要：学生
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private String url;
	private List<School> schools;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
}
