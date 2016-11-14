package com.chen.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.chen.domain.LoginLogMapper;
import com.chen.model.LoginLogBean;
import com.chen.model.PageBean;
import com.chen.service.ILoginLog;
import com.chen.util.PageUtil;
@Service
public class LoginLogServiceImpl implements ILoginLog{
	
	private static final Logger logger = LogManager.getLogger(LoginLogServiceImpl.class);
	@Autowired
	private LoginLogMapper service;
	@Override
	public void saveLoginLog(LoginLogBean log) {
		try {
			service.insertSelective(log);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		
	}

	@Override
	public JSONObject getLogList(PageBean page,LoginLogBean log) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", log);
			int total = service.count(log);
			List<LoginLogBean> list = service.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

}
