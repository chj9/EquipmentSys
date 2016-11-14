package com.chen.controller;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chen.model.LoginLogBean;
import com.chen.model.PageBean;
import com.chen.service.ILoginLog;
import com.chen.util.ResponseUtil;
/**
 * 所有日志的接口
 * @author chenhongjie
 *@Tool
 * 2016年11月13日
 */
@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	private ILoginLog service;
	
	@RequestMapping("/loginLog_list")
	public void getLoginLog(PageBean page,LoginLogBean log,HttpServletResponse response){
		try {
			JSONObject o = service.getLogList(page, log);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
