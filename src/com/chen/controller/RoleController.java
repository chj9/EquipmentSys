package com.chen.controller;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.model.PageBean;
import com.chen.model.RoleBean;
import com.chen.model.User;
import com.chen.service.IRoleService;
import com.chen.util.ResponseUtil;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	private static final Logger logger=  LogManager.getLogger(RoleController.class);
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/geRoletListOption")	
	public void geRoletListOption(HttpServletResponse response){
		try {
			JSONArray data = roleService.geRoletListOption();
			ResponseUtil.write(data, response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	@RequestMapping("/list")	
	public void getRoleList(PageBean page,RoleBean role,HttpServletResponse response){
		try {
			JSONObject o = roleService.getRoleList(page, role);
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	@RequestMapping("/edit")
	public void preSave(RoleBean role,HttpServletResponse response){
		try {
			boolean status = roleService.update(role);
			if (status) {
				ResponseUtil.write("{\"success\":\"修改成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
			}
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
		boolean status = roleService.delete(Integer.parseInt(id));
		if (status) {
			ResponseUtil.write("{\"success\":\"删除成功\"}", response);
		} else {
			ResponseUtil.write("{\"errorMsg\":\"删除失败,该角色下还有用户\"}", response);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	@RequestMapping("/addRole")
	public void addRole(RoleBean role,HttpServletResponse response){
		try {
			boolean status = roleService.addRole(role);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
}
