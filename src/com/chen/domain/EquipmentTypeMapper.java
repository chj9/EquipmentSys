package com.chen.domain;

import java.util.List;
import java.util.Map;

import com.chen.model.Equipment;
import com.chen.model.EquipmentType;
import com.common.dao.BaseDAO;
public interface EquipmentTypeMapper extends BaseDAO<EquipmentType,Integer> {
	public void deleteByIds(Object[] ids);
	 public List<Equipment> findPageByParam(Map<String,Object> m);
}
