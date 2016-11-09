package com.chen.domain;





import java.util.List;
import java.util.Map;

import com.chen.model.Equipment;

import com.chen.model.Repair;
import com.common.dao.BaseDAO;



public interface RepairMapper extends BaseDAO<Repair, Integer> {

	//public void add(Repair repair);
	
	public void deleteByIds(Object[] ids);
	
	 public List<Equipment> findPageByParam(Map<String,Object> m);
	
	//public void update(Repair repair);
}
