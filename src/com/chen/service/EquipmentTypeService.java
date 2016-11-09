package com.chen.service;



import java.util.List;

import com.chen.model.EquipmentType;

public interface EquipmentTypeService {

	public List<EquipmentType> findAll();
	
	public int count();
	
	public void add(EquipmentType equipmentType);
	
	public void update(EquipmentType equipmentType);
	
	public void delete(int id);
	
	public EquipmentType loadById(int id);
}
