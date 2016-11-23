package com.chen.domain;

import java.util.List;
import java.util.Map;

import com.chen.model.EquPriceBean;
import com.common.dao.BaseDAO;

public interface EquPriceMapper extends BaseDAO<EquPriceBean,Integer>{
	 public List<EquPriceBean> findPageByParam(Map<String,Object> m);

}
