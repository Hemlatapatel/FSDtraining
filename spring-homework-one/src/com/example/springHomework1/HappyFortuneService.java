package com.example.springHomework1;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

   private Random  random = new Random();
	String[] fortune = { 
			"Be aware of wolf in sheep's clothing",
			"delegence is the mother of good luck",
			"work is a journey",
			"hard work beats the talent"
	};
	

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int  i = random.nextInt(fortune.length);
		return fortune[i];
	}

}
