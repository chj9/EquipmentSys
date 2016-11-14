package com.chen.domain;

import java.util.List;
import java.util.Map;

import com.chen.model.LoginLogBean;

import com.common.dao.BaseDAO;

public interface LoginLogMapper extends BaseDAO<LoginLogBean,Integer> {
	List<LoginLogBean> findPageByParam(Map<String, Object> m);

}
