package com.chen.service.impl;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.domain.UserMapper;
import com.chen.model.PageBean;
import com.chen.model.User;
import com.chen.service.UserService;
import com.chen.util.PageUtil;



@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userDao;
	
	@Override
	public User login(User user) {
		List<User> list = userDao.login(user);
		for(User us:list){
			user.setId(us.getId());
		}
		return user;
	}

	@Override
	public JSONObject getUserList(PageBean pageBean,User user){
		Map<String,Object> m = PageUtil.getPageAndRow(pageBean);
		m.put("param", user);
		int total = userDao.count(user);
		List<User> list = userDao.findPageByParam(m);

		JSONObject data =PageUtil.ListBeanToJSON(list, total);
		return data;
	}

	@Override
	public int count(User user) {
		return userDao.count(user);
	}

	@Override
	public boolean delete(Integer id) {
		try {
			if(id==null){
				return false;
			}
			userDao.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean add(User user) {
		try {
			if(user==null){
				return false;
			}
			userDao.insertSelective(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
			if(user==null){
				return false;
			}
			userDao.updateByPrimaryKeySelective(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loadById(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean existUserByDeptId(int deptId) {
		return userDao.existUserByDeptId(deptId);
	}

}
