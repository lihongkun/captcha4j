package com.lihongkun.captcha4j.challenge;

import java.security.SecureRandom;

import com.google.common.base.Preconditions;

/**
 * random char challenge , the riddle equals the result
 * @author Allen Lee
 * @date 2017-02-26
 */
public class RandomChallengeProvider implements ChallengeProvider {

	private SecureRandom random = new SecureRandom();
	
	private String str = "abcdefghijklnmopqrstuvwxyz0123456789";
	
	private int maxLength;
	
	private int minLength;
	
	public RandomChallengeProvider(int minLength,int maxLength){
		Preconditions.checkArgument(maxLength>=minLength, "maxLength must equal or greater than minLength!");
		this.maxLength = maxLength;
		this.minLength = minLength;
	}
	
	public Challenge getChallenge() {
		
		int length = minLength;
		if(maxLength != minLength){
			length+= random.nextInt(maxLength - minLength);
		}
		
		StringBuffer accum = new StringBuffer();
		for(int i = 0 ;i < length ; i++){
			accum.append(getRandomChar());
		}
		
		String riddle = accum.toString();
		
		Challenge challenge = new Challenge();
		
		challenge.setResult(riddle);
		challenge.setRiddle(riddle);
		
		return challenge;
	}
	
	private char getRandomChar(){
		int i = random.nextInt(35);
		return str.charAt(i);
	}

}
