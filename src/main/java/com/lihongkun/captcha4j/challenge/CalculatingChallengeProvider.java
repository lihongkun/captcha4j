package com.lihongkun.captcha4j.challenge;

import java.security.SecureRandom;

/**
 * simple expression captcha
 * @author Allen Lee
 * @date 2017-02-26
 */
public class CalculatingChallengeProvider implements ChallengeProvider {

	private SecureRandom random = new SecureRandom();
	
	private static final String RES_MSG = " = ?";
	
	private String add;
	
	private String minus;
	
	private String multiply;
	
	public CalculatingChallengeProvider(String add,String minus,String multiply){
		this.add = add;
		this.minus = minus;
		this.multiply = multiply;
	}
	
	public Challenge getChallenge() {
		
		Challenge challenge = new Challenge();
		
		int left = 0;
		int right = 0;
		
		int max = random.nextInt(10)+1;
		int min = random.nextInt(10)+1;
		
		if(max>=min){
			left = max;
			right = min;
		}else {
			left = min;
			right = max;
		}
		
		StringBuffer accum = new StringBuffer();
		
		int opr = random.nextInt(3);
		if(opr == 0){
			challenge.setResult(String.valueOf(left+right));
			challenge.setRiddle(accum.append(left).append(add).append(right).append(RES_MSG).toString());
		}else if(opr == 1){
			challenge.setResult(String.valueOf(left-right));
			challenge.setRiddle(accum.append(left).append(minus).append(right).append(RES_MSG).toString());
		}else if(opr == 2){
			challenge.setResult(String.valueOf(left*right));
			challenge.setRiddle(accum.append(left).append(multiply).append(right).append(RES_MSG).toString());
		}
		
		return challenge;
	}
}
