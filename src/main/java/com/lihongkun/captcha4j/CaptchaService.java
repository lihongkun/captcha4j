package com.lihongkun.captcha4j;

/**
 * Captcha Service
 * @author Allen Lee
 * @date 2017-02-26
 */
public interface CaptchaService<T> {
	
	/**
	 * get the captcha for id
	 * @param id 	such as sessionid
	 * @return captcha
	 */
	public T getCaptchaForId(String id);
	
	/**
	 * validate a captcha
	 * @param id		
	 * @param captcha
	 * @return validate result
	 */
	public boolean validateCaptcha(String id,String captcha);
	
}