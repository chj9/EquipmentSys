package com.chen.model;

import java.io.Serializable;

import com.common.BaseBean;

public class RoleBean extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String roleName;
	private String create_at;
	private String remark;
	private Integer roleStatus; //1有效，0无效

	
	
	public Integer getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
