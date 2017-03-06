package com.lihongkun.captcha4j.store;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public class RedisStoreProvider implements StoreProvider {

	private static final String PREFIX = "captcha4j";
	
	private JedisCluster jedisCluster;
	
	private int expire;
	
	public RedisStoreProvider(JedisCluster jedisCluster,int expire){
		this.jedisCluster = jedisCluster;
		this.expire = expire;
	}
	
	public String get(String key) {
		return jedisCluster.get(PREFIX+key);
	}

	public void set(String key, String val) {
		jedisCluster.set(PREFIX+key, val);
		jedisCluster.expire(PREFIX+key, expire);
	}

	public void del(String key) {
		jedisCluster.del(PREFIX+key);
	}

}
