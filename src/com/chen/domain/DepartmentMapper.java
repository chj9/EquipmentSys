package com.chen.domain;

import java.util.List;
import java.util.Map;

import com.chen.model.Department;
import com.common.dao.BaseDAO;

public interface DepartmentMapper extends BaseDAO<Department,Integer> {

    public void	deleteByIds(Object[] id);

    public List<Department> findPageByParam(Map<String,Object> m);

}
