package com.chen.model;

import java.io.Serializable;



public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//部门ID
	private Integer id; 
	//部门名称
	private String deptName;
	//备注
	private String remark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String toString(){
		return null;
	}
	
}
