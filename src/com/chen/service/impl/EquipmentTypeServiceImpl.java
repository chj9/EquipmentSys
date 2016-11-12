package com.chen.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.EquipmentTypeMapper;
import com.chen.model.EquipmentType;
import com.chen.service.IEquipmentTypeService;



@Service("equipmentTypeService")
public class EquipmentTypeServiceImpl implements IEquipmentTypeService{

	@Autowired
	private EquipmentTypeMapper equipmentTypeDao;
	
	@Override
	public List<EquipmentType> findAll() {
		return equipmentTypeDao.findAll();
	}

	@Override
	public int count() {
		return equipmentTypeDao.count(null);
	}

	@Override
	public void add(EquipmentType equipmentType) {
		equipmentTypeDao.insertSelective(equipmentType);
	}

	@Override
	public void update(EquipmentType equipmentType) {
		equipmentTypeDao.updateByPrimaryKeySelective(equipmentType);
	}

	@Override
	public void delete(int id) {
		equipmentTypeDao.deleteByPrimaryKey(id);
	}

	@Override
	public EquipmentType loadById(int id) {
		return equipmentTypeDao.selectByPrimaryKey(id);
	}

}
