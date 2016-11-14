package com.chen.service;

import net.sf.json.JSONObject;

import com.chen.model.PageBean;
import com.chen.model.User;



public interface IUserService {

	public User login(User user);
	
	public JSONObject getUserList(PageBean pageBean,User user);
	
	public int count(User user);
	
	public boolean delete(Integer id);
	
	public boolean add(User user);
	
	public boolean update(User user);
	
	public User loadById(Integer id);
	/**
	 * 判断部门表和角色表是否有用户
	 *@2016年11月13日
	 *@return
	 */
	public boolean existUserByDeptId(int deptId);
	public boolean existUserByRoleId(int deptId);
}
