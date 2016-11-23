package com.chen.service;

import java.util.List;

import com.chen.model.EquPriceBean;
import com.chen.model.PageBean;

import net.sf.json.JSONObject;

public interface IEquPriceService {
	public JSONObject getEquList(PageBean page,EquPriceBean equ);
	public boolean deleteEquPriceById(Integer id);
	public boolean updateEquPrice(EquPriceBean equ);
	public boolean addEquPrice(EquPriceBean equ);
	
	public List<EquPriceBean> getEquPriceExcelData();
}
