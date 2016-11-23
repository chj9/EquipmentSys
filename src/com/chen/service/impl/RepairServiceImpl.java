package com.chen.service.impl;



import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.RepairMapper;
import com.chen.model.Equipment;
import com.chen.model.PageBean;
import com.chen.model.Repair;
import com.chen.model.RoleBean;
import com.chen.service.IRepairService;
import com.chen.util.PageUtil;
import com.mysql.jdbc.StringUtils;



@Service("repairService")
public class RepairServiceImpl implements IRepairService{
	private static final Logger logger = LogManager.getLogger(RepairServiceImpl.class);
	@Autowired
	private RepairMapper service;
	@Override
	public JSONObject getRepairList(PageBean page, Repair repair) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", repair);
			int total = service.count(repair);
			List<Equipment> list = service.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return null;
		}
	
	}

	@Override
	public boolean updateStatus(Repair repair) {
		try {
			service.updateByPrimaryKeySelective(repair);
			if(repair.getState()!=null){
			if(repair.getState()==1){
			repair.setStateName("正常");
			}
			if(repair.getState()==3){
				repair.setStateName("报废");
			}
			service.updateEquStatus(repair);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean saveRepair(Repair repair) {
	try {
			service.insertSelective(repair);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean updateEquStstus(Repair repair) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistByEquId(Integer id) {
		try {
			List<Equipment> list = service.isExistByEquId(id);
			if(list!=null){
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
		
	}

	@Override
	public boolean deleteByEquId(Integer id) {
		try {
			service.deleteByEquId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	
	}

}
