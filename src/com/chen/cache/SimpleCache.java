package com.chen.cache;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

/**
 * 缓存通用方法
 * @author chenhongjie
 *@Tool
 * 2016年11月5日
 */
@Service
public class SimpleCache<T> implements ICache<T> {

	/**
	 * 缓存数据索引
	 */
	private Map<String, LastCache<T>> cache = new ConcurrentHashMap<String, LastCache<T>>();

	/**
	 * 缓存超时时间，单位：毫秒
	 */
	private Long expired = 0L;

	public SimpleCache() {
		this(5 * 1000 * 60L);// 默认5分钟
	}

	public SimpleCache(Long expired) {
		this.expired = expired;
	}

	public void refresh(String key, T target) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		}
		cache.put(key, new LastCache<T>(target));
	}

	public T getCache(String key) {
		if (this.isExpired(key)) {
			return null;
		}

		return cache.get(key).getData();
	}

	public Boolean isExpired(String key) {
		if (!this.exist(key)) {
			return true;
		}

		long currtime = new Date().getTime();
		long lasttime = cache.get(key).getRefreshtime();
		long expire = cache.get(key).getExpires();

		return (currtime - lasttime) > expire;
	}

	public void setExpired(String key, long millsec) {
		if (cache.containsKey(key)) {
			LastCache lc = cache.get(key);
			if (lc != null) {
				lc.setExpires(millsec);
				cache.put(key, lc);
			}
		}
	}

	public Boolean exist(String key) {
		return cache.containsKey(key);
	}

	public void remove(String key) {
		cache.remove(key);
	}

}
