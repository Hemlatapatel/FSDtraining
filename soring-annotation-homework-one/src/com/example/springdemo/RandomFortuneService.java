package com.example.springdemo;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	Random random = new Random();
	List<String> fortuneList = new ArrayList<String>();

	
	int i = 0;
	FileReader fr;
	BufferedReader br;

	@PostConstruct
	public void doSomeInitStuff() {
		System.out.println("inside the initStuff");
		try {
			fr = new FileReader("fortune.txt");
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				fortuneList.add(str);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public String getFortune() {
		// TODO Auto-generated method stub

		int j = random.nextInt(fortuneList.size());
		return fortuneList.get(j);
	}
	
	@PreDestroy
	public void doSomeCleanupStuff() {
		try {
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
