
package com.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("classpath:sport.properties")

public class FootballCoach implements Coach {

	@Value("${foo.emailAddress}")
	private String emailAddress;
	@Value("${foo.team}")
	private String team;

	// property injection
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public FootballCoach() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*
	 * // constructor injection
	 * 
	 * @Autowired public FootballCoach(FortuneService fortuneService) { super();
	 * this.fortuneService = fortuneService; }
	 */

	/*
	 * // setter injection
	 * 
	 * @Autowired public void setFortuneService(@Qualifier("fileFortuneService")
	 * FortuneService fortuneService) { this.fortuneService = fortuneService; }
	 */
	
	/*
	 * // custom method injection
	 * 
	 * @Autowired public void myFortune(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "FootballCoach: practise forward today for 2 hrs.";
	}

	@Override 
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public String getTeam() {
		return team;
	}


	@PostConstruct
	public void doSomeIntitStuff() {
		System.out.println("inside InitStuff()");
	}
	
	@PreDestroy
	public void doSomeCleanupStuff()
	{
		System.out.println("inside doSomeCleanupStuff");
	}
}
