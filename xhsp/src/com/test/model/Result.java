/*************************************************************************************************
 * 版权所有 (C)2015
 * 
 * 文件名称：Result.java
 * 内容摘要：Result.java
 * 当前版本：TODO
 * 作        者：李加蒙1605651971@qq.com
 * 完成日期：2015年12月17日 下午4:35:32
 * 修改记录：
 * 修改日期：2015年12月17日 下午4:35:32
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.test.model;

import java.io.Serializable;
import java.util.List;

/**
 * @filename 文件名称：Result.java
 * @contents 内容摘要：成绩
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int result;
	private List<Person> persons;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
