package com.softeer.caart.global.utils;

import java.util.Random;

public class RandomUtils {
	public static int generateBudgetRandomly() {
		final int START = 4200;
		final int END = 6900;
		final int COUNT = (END - START) / 100 + 1;
		return START + (new Random().nextInt(COUNT) * 100);
	}
}
