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


import com.chen.model.Department;
import com.chen.model.PageBean;
import com.chen.service.IDepartmentService;
import com.chen.service.IUserService;
import com.chen.util.ResponseUtil;

/**
 * 
 * @author chenhongjie
 *@Tool
 * 2016年10月19日
 */

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger logger = LogManager.getLogger(DepartmentController.class);
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/list")
	public void list(PageBean page,Department s_department,HttpServletResponse response){
		try {
		JSONObject o = departmentService.getDeptList(page, s_department);
		ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
	
	@RequestMapping("/save")
	public void save(Department department,HttpServletResponse response){
			try {
				boolean  status =	departmentService.add(department);
			if (status) {
				ResponseUtil.write("{\"success\":\"添加成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"添加失败\"}", response);
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		if(userService.existUserByDeptId(Integer.parseInt(id))){
			ResponseUtil.write("{\"errorMsg\":\"该部门下面还有用户,无法删除\"}", response);
		}else{
			boolean  status = departmentService.delete(Integer.parseInt(id));
			if (status) {
				ResponseUtil.write("{\"success\":\"删除成功\"}", response);
			} else {
				ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
			}			
		}
	}
	@RequestMapping("/update")
	public void update(Department department,HttpServletResponse response){
		try {
			boolean  status =	departmentService.update(department);
		if (status) {
			ResponseUtil.write("{\"success\":\"修改成功\"}", response);
		} else {
			ResponseUtil.write("{\"errorMsg\":\"修改失败\"}", response);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/getDeptListOption")
	public void getDeptListOption(HttpServletResponse response){
		try {
			JSONArray o = departmentService.getDeptListOption();
			ResponseUtil.write(o, response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		}
	}
}
