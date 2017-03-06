package com.lihongkun.captcha4j.challenge;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public class Challenge {
	
	/**
	 * the result of riddle
	 */
	private String result;
	
	/**
	 * the riddle string
	 */
	private String riddle;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRiddle() {
		return riddle;
	}

	public void setRiddle(String riddle) {
		this.riddle = riddle;
	}
}
