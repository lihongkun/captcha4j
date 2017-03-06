package com.lihongkun.captcha4j;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.lihongkun.captcha4j.challenge.ChallengeProvider;
import com.lihongkun.captcha4j.store.StoreProvider;

/**
 * 
 * @author Allen Lee
 * @date 2017-02-26
 */
public class ImageCaptchaService extends GenericCaptchaService<BufferedImage> {

	private int width;

	private int height;

	private Font font;

	private Color color;

	public ImageCaptchaService(StoreProvider storeProvider, ChallengeProvider challengeProvider, int width, int height,
			Font font, Color color) {
		super(storeProvider, challengeProvider);
		this.width = width;
		this.height = height;
		this.font = font;
		this.color = color;
	}

	public BufferedImage generate(String riddle) {

		int size = riddle.length();

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();

		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);

		Random random = new Random();
		g2.setColor(color);
		for (int i = 0; i < 20; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g2.drawLine(x, y, x + xl + 40, y + yl + 20);
		}

		g2.setFont(font);
		g2.setColor(color);

		char[] chars = riddle.toCharArray();
		for (int i = 0; i < size; i++) {
			g2.drawChars(chars, i, 1, ((width - 10) / size) * i + 5, height / 2 + font.getSize() / 2 - 10);
		}
		g2.dispose();

		return image;
	}

}
