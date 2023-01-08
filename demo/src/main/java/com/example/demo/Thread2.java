package com.example.demo;

import com.example.pojo.data;

public class Thread2 extends Thread {
	@Override
	public void run() {
		
		data.even();
		
		
	}
}
