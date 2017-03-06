package com.lihongkun.captcha4j.challenge;

import org.junit.Test;

import com.lihongkun.captcha4j.challenge.Challenge;
import com.lihongkun.captcha4j.challenge.RandomChallengeProvider;

public class RandomChallengeProviderTest {

	@Test
	public void testGetChallenge() {
		RandomChallengeProvider provider = new RandomChallengeProvider(4, 4);
		
		Challenge challenge = provider.getChallenge();
		
		System.out.println(challenge.getResult());
		System.out.println(challenge.getRiddle());
	}

}
