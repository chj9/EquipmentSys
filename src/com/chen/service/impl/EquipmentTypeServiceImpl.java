package com.chen.service.impl;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.EquipmentTypeMapper;
import com.chen.model.Equipment;
import com.chen.model.EquipmentType;
import com.chen.model.PageBean;
import com.chen.service.IEquipmentTypeService;
import com.chen.util.PageUtil;

@Service("equipmentTypeService")
public class EquipmentTypeServiceImpl implements IEquipmentTypeService{
	private static final Logger logger = LogManager.getLogger(EquipmentTypeServiceImpl.class);
	@Autowired
	private EquipmentTypeMapper equipmentTypeDao;

	@Override
	public JSONArray getTypeOption() {
		try {
			List<EquipmentType> list = equipmentTypeDao.findAll();
			JSONArray data = PageUtil.ListBeantoArray(list);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public boolean addType(EquipmentType equipmentType) {
		try {
			if(equipmentType.getTypeName()==null){
				return false;
			}
			equipmentTypeDao.insertSelective(equipmentType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	
	}

	@Override
	public boolean updateType(EquipmentType equipmentType) {
		try {
			if(equipmentType.getTypeName()==null){
				return false;
			}
			equipmentTypeDao.updateByPrimaryKeySelective(equipmentType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	
	}

	@Override
	public boolean deleteType(Integer id) {
		try {
			
			if(id==null){
				return false;
			}
			equipmentTypeDao.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}

	}

	@Override
	public JSONObject getTypeList(PageBean page, EquipmentType type) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", type);
			int total = equipmentTypeDao.count(type);
			List<Equipment> list = equipmentTypeDao.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}
}
