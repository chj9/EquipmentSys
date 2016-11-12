package com.chen.domain;


import java.util.List;
import java.util.Map;

import com.chen.model.RoleBean;
import com.common.dao.BaseDAO;

public interface RoleMapper extends BaseDAO<RoleBean,Integer>{

	List<RoleBean> findPageByParam(Map<String, Object> m);

}
