package com.chen.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.RepairMapper;

import com.chen.model.Repair;
import com.chen.service.RepairService;



@Service("repairService")
public class RepairServiceImpl implements RepairService{

	@Autowired
	private RepairMapper repairDao;
	
	
	@Override
	public List<Repair> findAll() {
		return repairDao.findAll();
	}

	@Override
	public int count() {
		return repairDao.count(null);
	}




}
