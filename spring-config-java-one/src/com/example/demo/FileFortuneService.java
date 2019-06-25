package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "It is file fortune service";
	}

}
