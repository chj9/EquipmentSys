package com.chen.service;

import net.sf.json.JSONObject;

import com.chen.model.PageBean;
import com.chen.model.User;



public interface UserService {

	public User login(User user);
	
	public JSONObject getUserList(PageBean pageBean,User user);
	
	public int count(User user);
	
	public boolean delete(Integer id);
	
	public boolean add(User user);
	
	public boolean update(User user);
	
	public User loadById(Integer id);
	
	public boolean existUserByDeptId(int deptId);
}
