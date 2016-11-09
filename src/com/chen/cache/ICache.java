package com.chen.cache;

/**
 * 缓存接口层
 * @author chenhongjie
 *@Tool
 * 2016年11月5日
 */
public interface ICache<T>  {
	  /**
	   * 刷新缓存数据
	   * 
	   * @param key 缓存key
	   * @param target 新数据
	   */
	  void refresh(String key, T target);
	  
	  /**
	   * 获取缓存
	   * 
	   * @param key 缓存key
	   * @return 缓存数据
	   */
	  T getCache(String key);
	  
	  /**
	   * 判断缓存是否过期
	   * 
	   * @param key 缓存key
	   * @return 如果缓存过期返回true， 否则返回false
	   */
	  Boolean isExpired(String key);
	  
	  /**
	   * 设置缓存过期时间
	   * 
	   * @param key 缓存key
	   * @param millsec 缓存过期时间，单位：毫秒
	   */
	  void setExpired(String key,long millsec);
	  
	  /**
	   * 是否存在缓存对象
	   * 
	   * @param key 缓存key
	   * @return 存在返回true，不存在返回false
	   */
	  Boolean exist(String key);
	  
	  /**
	   * <p>Title: remove<／p>
	   * <p>Description: 删除缓存<／p>
	   * @param key 缓存key
	   *
	   */
	  void remove(String key);
}
