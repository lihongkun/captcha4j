package com.lihongkun.captcha4j;

import com.google.common.base.Preconditions;
import com.lihongkun.captcha4j.challenge.Challenge;
import com.lihongkun.captcha4j.challenge.ChallengeProvider;
import com.lihongkun.captcha4j.store.StoreProvider;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public abstract class GenericCaptchaService<T> implements CaptchaService<T> {

	protected StoreProvider storeProvider;
	
	protected ChallengeProvider challengeProvider;
	
	public GenericCaptchaService(StoreProvider storeProvider,ChallengeProvider challengeProvider){
		
		Preconditions.checkArgument(storeProvider!=null);
		Preconditions.checkArgument(challengeProvider!=null);
		
		this.storeProvider = storeProvider;
		this.challengeProvider = challengeProvider;
	}
	
	public T getCaptchaForId(String id) {
		
		Challenge challenge = challengeProvider.getChallenge();
		
		//store the result
		storeProvider.set(id,challenge.getResult());
		
		return generate(challenge.getRiddle());
	}

	public boolean validateCaptcha(String id, String captcha) {
		String val = storeProvider.get(id);
		if(val==null||captcha==null)
			return false;
		else if(!val.equals(captcha)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param riddle
	 * @return 
	 */
	public abstract T generate(String riddle);
}
