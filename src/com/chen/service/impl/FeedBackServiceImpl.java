package com.chen.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.chen.domain.FeedBackMapper;
import com.chen.model.FeedBackBean;
import com.chen.model.PageBean;
import com.chen.model.RoleBean;
import com.chen.service.IFeedBackService;
import com.chen.util.DateUtil;
import com.chen.util.PageUtil;

@Service
public class FeedBackServiceImpl implements IFeedBackService{
	
	private static final Logger logger = LogManager.getLogger(FeedBackServiceImpl.class);
	
	@Autowired
	private FeedBackMapper service;
	@Override
	public boolean saveFeedBack(FeedBackBean feedback) {
		try {
			if(feedback==null){
				return false;
			}
			feedback.setFeedtime(DateUtil.getCurrentDateStr());
			service.insertSelective(feedback);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
			return false;
		}
		
	}

	@Override
	public JSONObject getFeedBackList(PageBean page, FeedBackBean feedback) {
		try {
			Map<String, Object>  m = PageUtil.getPageAndRow(page);
			m.put("param", feedback);
			int total = service.count(feedback);
			List<RoleBean> list = service.findPageByParam(m);
			JSONObject data =PageUtil.ListBeanToJSON(list, total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
		return null;
	}

	@Override
	public boolean deleteFeedBackById(Integer id) {
		try {
			if(id==null){
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

}
