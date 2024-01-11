package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	
	//int timeOfDay is based on 24 hour clock, parsed before input into method.
	public boolean isBedTime(int timeOfDay, boolean isWeekday) {
		return (timeOfDay > 20 && isWeekday) || (timeOfDay > 22 && !isWeekday);
	}
	
	
	public int randomNumberSquared() {
		return (int) Math.pow(getRandomInt(), 2);
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	
}
