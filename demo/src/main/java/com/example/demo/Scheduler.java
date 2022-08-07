package com.example.demo;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	//@Scheduled(cron = "0/5 * 19-20 * * *")
	//@Scheduled(fixedRate = 10000)
	//@Scheduled(fixedDelay = 5000 ,initialDelay = 10000)
	public void test() {
		System.out.println("***Fixed Rate Scheduled services ***  " + new Date());
	}
}
