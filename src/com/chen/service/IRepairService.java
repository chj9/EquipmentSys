package com.chen.service;



import java.util.List;

import com.chen.model.Repair;



public interface IRepairService {

	public List<Repair> findAll();
	
	public int count();
	
}
