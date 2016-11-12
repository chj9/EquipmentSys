package com.chen.service;

import net.sf.json.JSONObject;

import com.chen.model.FeedBackBean;
import com.chen.model.PageBean;

public interface IFeedBackService {
	public boolean saveFeedBack(FeedBackBean feedback);
	public JSONObject getFeedBackList(PageBean page,FeedBackBean feedback);
	public boolean deleteFeedBackById(Integer id);
}
