package com.lihongkun.captcha4j.store;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public interface StoreProvider {

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key);
	
	/**
	 * 
	 * @param key
	 * @param val
	 */
	public void set(String key,String val);
	
	/**
	 * 
	 * @param key
	 */
	public void del(String key);
}
