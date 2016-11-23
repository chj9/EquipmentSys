package com.chen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.chen.domain.EquPriceMapper;
import com.chen.model.EquPriceBean;
import com.chen.model.PageBean;
import com.chen.service.IEquPriceService;
import com.chen.util.DateUtil;
import com.chen.util.PageUtil;
@Service
public class EquPriceImpl implements IEquPriceService{
	private static final Logger logger = LogManager.getLogger(EquPriceImpl.class);
	@Autowired
	private EquPriceMapper service;
	@Override
	public JSONObject getEquList(PageBean page, EquPriceBean equ) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", equ);
			int total = service.count(equ);
			List<EquPriceBean> li = service.findPageByParam(m);
			List<EquPriceBean> list = new ArrayList<EquPriceBean>();
			for(EquPriceBean e :li){
					e.setElectricityName(e.getElectricity()==1?"直流电":"交流电");
					list.add(e);
			}
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public boolean deleteEquPriceById(Integer id) {
		try {
			if (id==null) {
				return false;
			}
		  service.deleteByPrimaryKey(id);
		  return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}

	}

	@Override
	public boolean updateEquPrice(EquPriceBean equ) {
		try {
			if(equ.getId()==null){
				return false;
			}
			service.updateByPrimaryKeySelective(equ);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public boolean addEquPrice(EquPriceBean equ) {
		try {
			equ.setCreate_time(DateUtil.getCurrentDateStr());
			System.out.println("记录人是:"+equ.getCreate_man());
			service.insertSelective(equ);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
	}

	@Override
	public List<EquPriceBean> getEquPriceExcelData() {
		try {
			return service.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

}
