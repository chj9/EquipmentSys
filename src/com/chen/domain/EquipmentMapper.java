package com.chen.domain;





import java.util.List;
import java.util.Map;

import com.chen.model.Equipment;
import com.common.dao.BaseDAO;



public interface EquipmentMapper extends BaseDAO<Equipment, Integer> {


	public void deleteByIds(Object[] ids);
	
	 public List<Equipment> findPageByParam(Map<String,Object> m);
	 public Integer isExistequByTypeId(Integer id);
	
}
