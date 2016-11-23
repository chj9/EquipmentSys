package com.chen.service.impl;



import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.DepartmentMapper;
import com.chen.model.Department;
import com.chen.model.PageBean;
import com.chen.service.IDepartmentService;
import com.chen.util.DateUtil;
import com.chen.util.PageUtil;
/**
 * 部门服务
 * @author chenhongjie
 *@Tool
 * 2016年11月13日
 */
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService{
	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentMapper departmentDao;
	

	@Override
	public boolean add(Department department) {
		try {
			department.setCreate_at(DateUtil.getCurrentDateStr());
			departmentDao.insertSelective(department);
			return true;
		} catch (Exception e) {
			logger.error("",e);
			return false;
		}
	
	}
	@Override
	public boolean update(Department department) {
		try {
			if(department.getId()==null){
				return false;
			}
		departmentDao.updateByPrimaryKeySelective(department);
		return true;
		
		} catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
			return false;
	}
	}
	@Override
	public boolean delete(Integer id) {
		try {
			if(id==null){
				return false;
			}
			departmentDao.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public JSONArray getDeptListOption() {
		try {
			List<Department>  list =departmentDao.findAll();
			JSONArray data =PageUtil.ListBeantoArray(list);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}
	@Override
	public JSONObject getDeptList(PageBean page, Department department) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", department);
			int total = departmentDao.count(department);
			List<Department> list = departmentDao.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}



}
