package com.chen.service.impl;



import java.util.List;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.DepartmentMapper;
import com.chen.model.Department;
import com.chen.service.DepartmentService;
import com.chen.util.PageUtil;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper departmentDao;
	
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public int count(Department department) {
		return departmentDao.count(null);
	}
	@Override
	public boolean add(Department department) {
		departmentDao.insertSelective(department);
		return false;
	}
	@Override
	public boolean update(Department department) {
		departmentDao.updateByPrimaryKeySelective(department);
		return false;
	}
	@Override
	public boolean delete(Integer id) {
		departmentDao.deleteByPrimaryKey(id);
		return false;
	}
	@Override
	public Department loadById(Integer id) {
		return departmentDao.selectByPrimaryKey(id);
	}

	@Override
	public JSONArray getDeptListOption() {
		try {
			List<Department>  list =departmentDao.findAll();
			JSONArray data =PageUtil.ListBeantoArray(list);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
