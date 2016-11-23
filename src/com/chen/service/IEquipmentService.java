package com.chen.service;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chen.model.Equipment;
import com.chen.model.PageBean;
import com.chen.model.Repair;
import com.chen.model.RoomBean;

public interface IEquipmentService {
	//Equipment操作
	public JSONObject getEquipmentList(PageBean page,Equipment equipment);
	
	public boolean deleteEquipment(Integer id);
	
	public boolean addEquipment(Equipment equipment);
	
	public List<Equipment> getEquExcelData();
	
	public boolean updateEquipment(Equipment equipment);
	
	//ROOM操作
	public JSONArray getRoomList();
	
	public boolean deleteRoom(Integer id);
	
	public boolean addRoom(RoomBean room);
	
	public boolean updateRoom(RoomBean room);
	
	public boolean isExistequByTypeId(Integer id);
	
	public JSONArray getRoomOption();
	
	public boolean addRepair(Repair re);
	
	public List<Repair> getRepairExcelData();

}
