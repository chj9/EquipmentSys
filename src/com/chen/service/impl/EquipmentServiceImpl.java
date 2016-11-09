package com.chen.service.impl;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.EquipmentMapper;
import com.chen.domain.RepairMapper;
import com.chen.model.Equipment;
import com.chen.model.Repair;
import com.chen.model.User;
import com.chen.service.EquipmentService;



@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService{

	@Autowired
	private EquipmentMapper equipmentDao;
	
	@Autowired
	private RepairMapper repairDao;
	
	@Override
	public List<Equipment> findAll() {
		return equipmentDao.findAll();
	}

	@Override
	public int count() {
		return equipmentDao.count(null);
	}

	@Override
	public void delete(int id) {
		equipmentDao.deleteByPrimaryKey(id);
	}

	@Override
	public void add(Equipment equipment) {
		equipmentDao.insertSelective(equipment);
	}

	@Override
	public void update(Equipment equipment) {
		equipmentDao.updateByPrimaryKeySelective(equipment);
	}

	@Override
	public Equipment loadById(int id) {
		return equipmentDao.selectByPrimaryKey(id);
	}


	@Override
	public void addRepair(int id, String userMan) {
		Repair repair=new Repair();
		repair.setEquipmentId(id);
		repair.setUserMan(userMan);
		repairDao.insertSelective(repair);
		
		Equipment equipment=equipmentDao.selectByPrimaryKey(id);
		equipment.setState(2);
		equipmentDao.updateByPrimaryKeySelective(equipment);
	}

	@Override
	public void updateRepair(int id, int repairId,String repairMan, boolean success) {
		Repair repair=new Repair();
		repair.setId(repairId);
		repair.setRepairMan(repairMan);
		Equipment equipment=equipmentDao.selectByPrimaryKey(id);
		if(success){
			repair.setState(1);
			equipment.setState(1);
		}else{
			repair.setState(2);
			equipment.setState(3);
		}
		repairDao.updateByPrimaryKeySelective(repair);
		equipmentDao.updateByPrimaryKeySelective(equipment);
	}



}
