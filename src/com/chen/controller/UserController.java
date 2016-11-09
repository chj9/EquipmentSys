package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chen.model.PageBean;
import com.chen.model.User;
import com.chen.service.DepartmentService;
import com.chen.service.UserService;
import com.chen.util.ResponseUtil;
import com.mysql.jdbc.StringUtils;


/**
 * 
 * @author chenhongjie
 *@Tool
 * 2016年10月28日
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 登陆
	 *@2016年11月5日
	 *@return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		User resultUser=userService.login(user);
		if(resultUser.getId()==null){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "login";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/main.jsp";
		}
	}
	/**
	 * 登出
	 *@2016年11月5日
	 *@return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/list")
	public String list(PageBean pageBean,User user,HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session=request.getSession();
		if(session.getAttribute("currentUser")==null){
			return "login";
		}
		JSONObject o =userService.getUserList(pageBean, user);
		if(!StringUtils.isNullOrEmpty(o.getString("rows"))){
			ResponseUtil.write(o, response);
		}else{
			ResponseUtil.write("{\"errorMsg\":\"not data\"}", response);
		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("get user list error:",e);
		}
		return null;
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		System.out.println(id);
		boolean status = userService.delete(Integer.parseInt(id));
		if (status) {
			ResponseUtil.write("{\"success\":\"删除成功\"}", response);
		} else {
			ResponseUtil.write("{\"errorMsg\":\"删除失败\"}", response);
		}
	}
	
	@RequestMapping("/edit")
	public void preSave(User user,HttpServletResponse response){
		try {
			boolean status = userService.update(user);
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
	
	@RequestMapping("/addUser")
	public void save(User user,HttpServletResponse response){
		try {
		boolean  status = userService.add(user);
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
