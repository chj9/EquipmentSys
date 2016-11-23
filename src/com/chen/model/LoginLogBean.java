package com.chen.model;

import java.io.Serializable;

import com.common.BaseBean;

/**
 * 登陆信息记录
 * @author chenhongjie
 *@Tool
 * 2016年11月13日
 */
public class  LoginLogBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String login_name;
	private String role_name;
	private String user_status;
	private String client_ip;
	private String create_time;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
