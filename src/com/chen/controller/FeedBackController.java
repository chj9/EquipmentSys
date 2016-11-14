package com.chen.controller;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.model.FeedBackBean;
import com.chen.model.PageBean;
import com.chen.service.IFeedBackService;
import com.chen.util.ResponseUtil;

@Controller
@RequestMapping("/feed")
public class FeedBackController {
	private static final Logger logger = LogManager.getLogger(FeedBackController.class);
	@Autowired
	private IFeedBackService service;
	@RequestMapping("/saveFeed")	
	public void saveFeed(FeedBackBean feedback,HttpServletResponse response){
		try {
			
			boolean status = service.saveFeedBack(feedback);
			if(status){
				ResponseUtil.write("{'success':'反馈成功'}",response);
			}else{
				ResponseUtil.write("{'errorMsg':'反馈失败,请重试'}",response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	@RequestMapping("/list")
	public void getFeedBackList(PageBean page,FeedBackBean feedback,HttpServletResponse response){
		try {
			JSONObject o = service.getFeedBackList(page, feedback);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")String id,HttpServletResponse response){
		try {
			if(id==null){
				ResponseUtil.write("{\"errorMsg\":\"删除失败,ID为空\"}", response);
				return;
			}
				boolean status = service.deleteFeedBackById(Integer.parseInt(id));
				if (status) {
					ResponseUtil.write("{\"success\":\"删除成功\"}", response);
				} else {
					ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
}
