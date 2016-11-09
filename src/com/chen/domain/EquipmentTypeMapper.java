package com.chen.domain;




import java.util.List;
import java.util.Map;

import com.chen.model.Equipment;
import com.chen.model.EquipmentType;
import com.common.dao.BaseDAO;



public interface EquipmentTypeMapper extends BaseDAO<EquipmentType,Integer> {

//	public List<EquipmentType> find(PageBean pageBean,EquipmentType s_equipmentType);
	public void deleteByIds(Object[] ids);
	
	 public List<Equipment> findPageByParam(Map<String,Object> m);
//	public int count(EquipmentType s_equipmentType);
	
//	public void add(EquipmentType equipmentType);
	
//	public void update(EquipmentType equipmentType);
	
//	public void delete(int id);
	
//	public EquipmentType loadById(int id);
}
