package com.chen.service;

import com.chen.model.PageBean;
import com.chen.model.RoleBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface IRoleService {
	public JSONArray geRoletListOption();
	public JSONObject getRoleList(PageBean page,RoleBean role);
	public boolean update(RoleBean role);
	/**
	 * 角色彻底删除
	 *@2016年11月11日
	 *@return
	 */
	public boolean delete(Integer id);
	public boolean addRole(RoleBean role);

}
