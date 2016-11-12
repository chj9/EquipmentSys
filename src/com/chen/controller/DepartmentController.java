package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chen.model.Department;
import com.chen.service.IDepartmentService;
import com.chen.service.IUserService;

import com.chen.util.ResponseUtil;
import com.chen.util.StringUtil;
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
	public void list(@RequestParam(value="page",required=false)String page,Department s_department,HttpServletRequest request){
	
	
	
	}
	
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("mainPage", "department/save.jsp");
		mav.addObject("modeName", "部门管理");
		mav.setViewName("main");
		if(StringUtil.isNotEmpty(id)){
			mav.addObject("actionName", "部门修改");
			Department department=departmentService.loadById(Integer.parseInt(id));
			mav.addObject("department", department);
		}else{
			mav.addObject("actionName", "部门添加");			
		}
		return mav;
	}
	
	@RequestMapping("/save")
	public String save(Department department){
		if(department.getId()==null){
			departmentService.add(department);			
		}else{
			departmentService.update(department);
		}
		return "redirect:/department/list.do";
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		if(userService.existUserByDeptId(Integer.parseInt(id))){
			result.put("errorInfo", "该部门下存在用户，不能删除！");
		}else{
			departmentService.delete(Integer.parseInt(id));
			result.put("success", true);			
		}
		ResponseUtil.write(result, response);
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
