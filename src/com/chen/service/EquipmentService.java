package com.chen.service;



import java.util.List;

import com.chen.model.Equipment;



public interface EquipmentService {

	public List<Equipment> findAll();
	
	public int count();
	
	public void delete(int id);
	
	public void add(Equipment equipment);
	
	public void update(Equipment equipment);
	
	public Equipment loadById(int id);
	
	public void addRepair(int id,String userMan);
	
	public void updateRepair(int id,int repairId,String repairMan,boolean success);
}
