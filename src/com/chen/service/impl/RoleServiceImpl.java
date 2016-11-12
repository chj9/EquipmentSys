package com.chen.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chen.domain.RoleMapper;
import com.chen.model.PageBean;
import com.chen.model.RoleBean;
import com.chen.service.IRoleService;
import com.chen.util.DateUtil;
import com.chen.util.PageUtil;
@Service
public class RoleServiceImpl implements IRoleService{
	
	private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public JSONArray geRoletListOption() {
		try {
			List<RoleBean> list =roleMapper.findAll();
			 return  PageUtil.ListBeantoArray(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public JSONObject getRoleList(PageBean page,RoleBean role) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", role);
			int total = roleMapper.count(role);
			List<RoleBean> list = roleMapper.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return null;
		}
	}

	@Override
	public boolean update(RoleBean role) {
		try {
			role.setCreate_at(DateUtil.getCurrentDateStr());
			roleMapper.updateByPrimaryKeySelective(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			if(id==null){
				return false;
			}
			roleMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addRole(RoleBean role) {
		try {
			role.setCreate_at(DateUtil.getCurrentDateStr());
			roleMapper.insertSelective(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}
}
