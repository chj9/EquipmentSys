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
	private String  create_at;
	private Integer deptStatus;//1、有效 0、无效
	//备注
	private String remark;
	
	
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public Integer getDeptStatus() {
		return deptStatus;
	}
	public void setDeptStatus(Integer deptStatus) {
		this.deptStatus = deptStatus;
	}
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
