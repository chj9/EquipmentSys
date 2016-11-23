package com.chen.domain;

import java.util.List;
import java.util.Map;

import com.chen.model.Equipment;

import com.chen.model.Repair;
import com.common.dao.BaseDAO;

public interface RepairMapper extends BaseDAO<Repair, Integer> {
	 public List<Equipment> findPageByParam(Map<String,Object> m);
	 void updateEquStatus(Repair re);
	 List<Equipment> isExistByEquId(Integer id);
	 void deleteByEquId(Integer id);
}
