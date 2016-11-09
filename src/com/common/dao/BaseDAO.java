package com.common.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 泛形DAO顶层接口，Hibernate,Ibatis公共接口 抽象出了Hibernate和Ibatis公共的方法
 * 
 * @author chenhongjie
 * @version [V1]
 * @see Serializabl
 */
public interface BaseDAO<T extends Serializable, PK extends Serializable> {

	/**
	 * 通过主键ID查找对应的实体 接口方法，子类必须实现该方法
	 * 
	 * @param id
	 *            [泛型，主键ID编号]
	 * @return T [泛型，返回一个具体的实体]
	 * @exception throws [IEPGMException] [当数据库操作异常时将抛出该异常]
	 */
	T selectByPrimaryKey(PK id) throws DataAccessException;

	/**
	 * 查找所有实体 接口方法，用于查找所有实体，子类必须实现该方法
	 * 
	 * @return List<T> [返回所有符合条件的实体]
	 * @exception throws [DataAccessException] [当数据库操作异常时将抛出该异常]
	 */
	List<T> findAll() throws DataAccessException;

	/**
	 * 更新单个实体数据库update操作 根据实体的参数更新数据库中对应的记录
	 * 
	 * @param entity
	 *            实体对象，泛型，任何实现序列化的类
	 * @exception throws [DataAccessException] [当数据库操作发生失败时抛出该异常]
	 */
	
	void updateByPrimaryKey(T entity) throws DataAccessException;
	/**
	 * 更新单个实体数据库update操作 根据实体的参数更新数据库中对应的记录
	 * 
	 * @param entity
	 *            实体对象，泛型，任何实现序列化的类
	 * @exception throws [DataAccessException] [当数据库操作发生失败时抛出该异常]
	 */
	void updateByPrimaryKeySelective(T entity) throws DataAccessException;
	/**
	 * 保存单个实体数据库insert操作 根据实体内容插入到数据库
	 * 
	 * @param entity
	 *            实体对象，泛型，任何实现序列化的类
	 * @exception throws [DataAccessException] [当数据库操作发生失败时抛出该异常]
	 */
	void insert(T entity) throws DataAccessException;
	
	/**
	 * 保存单个实体数据库insert操作 根据实体内容插入到数据库
	 * @param entity
	 *            实体对象，泛型，任何实现序列化的类
	 * @exception throws [DataAccessException] [当数据库操作发生失败时抛出该异常]
	 */
	void insertSelective(T entity) throws DataAccessException;
	/**
	 * 获取数据总数,结合分页使用
	 *@2016年10月22日
	 *@return
	 */
	Integer count(T entity) throws DataAccessException;
	/**
	 * 按主键编号删除数据库对应单个实体 对应数据库delete操作
	 * 
	 * @param id
	 *            主键ID
	 * @exception throws [DataAccessException] [当数据库操作失败时抛出该异常]
	 */
	void deleteByPrimaryKey(PK id) throws DataAccessException;

}
