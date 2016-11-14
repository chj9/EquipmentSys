package com.chen.model;

import java.io.Serializable;

import com.common.BaseBean;


public class User extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer id;
	private String password;
	private String userName;
	private String trueName; //别名
	private Integer roleId;
	private Integer deptId;  // 部门id
	private String roleName; // 角色  1 管理员 2 使用者 3 维修者
	private String deptName; //部门名称 班级则是班级名称
	private String regtime;
	//-------注册时间段,关联regtime---------

	//--------------------
	private Integer userSta; //1、有效用户 2、无效用户
	
	public Integer getUserSta() {
		return userSta;
	}
	public void setUserSta(Integer userSta) {
		this.userSta = userSta;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
