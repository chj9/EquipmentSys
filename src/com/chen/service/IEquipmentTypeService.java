package com.chen.service;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chen.model.EquipmentType;
import com.chen.model.PageBean;

public interface IEquipmentTypeService {

	public JSONArray  getTypeOption();
	
	public boolean addType(EquipmentType equipmentType);
	
	public boolean updateType(EquipmentType equipmentType);
	
	public boolean deleteType(Integer id);
	
	public JSONObject getTypeList(PageBean page,EquipmentType type);
}
