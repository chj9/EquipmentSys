package com.chen.service;


import java.util.List;

import net.sf.json.JSONArray;

import com.chen.model.Department;




public interface DepartmentService {

	public List<Department> findAll();
	
	public int count(Department department);
	public JSONArray getDeptListOption();
	public boolean add(Department department);
	
	public boolean update(Department department);
	
	public boolean delete(Integer id);
	
	public Department loadById(Integer id);
}
