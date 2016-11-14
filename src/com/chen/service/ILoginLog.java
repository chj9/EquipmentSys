package com.chen.service;

import net.sf.json.JSONObject;

import com.chen.model.LoginLogBean;
import com.chen.model.PageBean;

public interface ILoginLog {
	public void saveLoginLog(LoginLogBean log);
	
	public JSONObject getLogList(PageBean page,LoginLogBean log);
}
