package com.lihongkun.captcha4j.challenge;

import org.junit.Test;

import com.lihongkun.captcha4j.challenge.CalculatingChallengeProvider;
import com.lihongkun.captcha4j.challenge.Challenge;

public class CalculatingChallengeProviderTest {

	@Test
	public void testGetChallenge() {
		CalculatingChallengeProvider provider = new CalculatingChallengeProvider("¼Ó", "¼õ", "³Ë");
		
		Challenge challenge = provider.getChallenge();
		
		System.out.println(challenge.getRiddle());
		System.out.println(challenge.getResult());
	}

}
