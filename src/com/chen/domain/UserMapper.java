package com.chen.domain;
import java.util.List;
import java.util.Map;

import com.chen.model.User;
import com.common.dao.BaseDAO;



public interface UserMapper extends BaseDAO<User, Integer> {

	public List<User> login(User user);

	public void deleteByIds(Object[] ids);
	
	
	 public List<User> findPageByParam(Map<String,Object> m);

   	public boolean existUserByDeptId(int deptId);
}
