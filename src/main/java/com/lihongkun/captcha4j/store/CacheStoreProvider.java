package com.lihongkun.captcha4j.store;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public class CacheStoreProvider implements StoreProvider {

	private Cache<String, String> cache;

	public CacheStoreProvider(long duration,long size) {
		cache = CacheBuilder.newBuilder().maximumSize(size).expireAfterWrite(duration, TimeUnit.SECONDS)
				.expireAfterAccess(1, TimeUnit.NANOSECONDS).concurrencyLevel(10).build();
	}

	public String get(String key) {
		return cache.getIfPresent(key);
	}

	public void set(String key, String val) {
		cache.put(key, val);
	}

	public void del(String key) {
		cache.invalidate(key);
	}

}
