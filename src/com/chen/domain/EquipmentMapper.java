package com.chen.domain;





import java.util.List;
import java.util.Map;
import com.chen.model.Equipment;
import com.common.dao.BaseDAO;



public interface EquipmentMapper extends BaseDAO<Equipment, Integer> {

//	public List<Equipment> find(PageBean pageBean,Equipment s_equipment);
	public void deleteByIds(Object[] ids);
	
	 public List<Equipment> findPageByParam(Map<String,Object> m);
//	public int count(Equipment s_equipment);
	
	//public void delete(int id);
//	public void add(Equipment equipment);
	
//	public void update(Equipment equipment);
	
//	public Equipment loadById(int id);
	
//	public boolean existEquipmentByTypeId(int typeId);
	
}
