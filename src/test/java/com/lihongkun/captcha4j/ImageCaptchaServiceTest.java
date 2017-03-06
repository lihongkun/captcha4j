package com.lihongkun.captcha4j;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.lihongkun.captcha4j.ImageCaptchaService;
import com.lihongkun.captcha4j.challenge.CalculatingChallengeProvider;
import com.lihongkun.captcha4j.challenge.ChallengeProvider;
import com.lihongkun.captcha4j.store.CacheStoreProvider;
import com.lihongkun.captcha4j.store.StoreProvider;

public class ImageCaptchaServiceTest {

	@Test
	public void test() throws Exception {
		String id = "10001";
		
		StoreProvider storeProvider = new CacheStoreProvider(10000, 1000);
		ChallengeProvider challengeProvider = new CalculatingChallengeProvider("+", "-", "*");
		
		Font font = new Font("Arial", Font.PLAIN, 48);
		Color color = new Color(0, 156, 0);
		
		ImageCaptchaService captchaService = new ImageCaptchaService(storeProvider, challengeProvider, 300, 50, font, color);
		
		BufferedImage image = captchaService.getCaptchaForId(id);
		
		ImageIO.write(image, "jpeg", new File("test.jpeg"));
	}

}
