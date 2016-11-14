package com.chen.service;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chen.model.Department;
import com.chen.model.PageBean;




public interface IDepartmentService {

	public JSONArray getDeptListOption();
	public boolean add(Department department);
	public boolean update(Department department);
	public JSONObject getDeptList(PageBean page,Department department);
	public boolean delete(Integer id);
	
}
