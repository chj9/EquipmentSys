package com.chen.service;

import com.chen.model.PageBean;
import com.chen.model.Repair;

import net.sf.json.JSONObject;

public interface IRepairService {
	public JSONObject getRepairList(PageBean page,Repair repair);
	public boolean updateStatus(Repair repair);
	public boolean saveRepair(Repair repair);
	public boolean updateEquStstus(Repair repair);
	public boolean isExistByEquId(Integer id);
	public boolean deleteByEquId(Integer id);
}
