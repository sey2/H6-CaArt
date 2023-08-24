package com.softeer.caart.global.utils;

import java.util.Random;

public class RandomUtils {
	public static int generateBudgetRandomly() {
		final int START = 42000000;
		final int END = 69000000;
		final int COUNT = (END - START) / 100 + 1;
		return START + (new Random().nextInt(COUNT) * 100);
	}
}
