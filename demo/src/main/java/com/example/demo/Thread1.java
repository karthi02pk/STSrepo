package com.example.demo;

import com.example.pojo.data;

public class Thread1 extends Thread{
	
	
	@Override
	public void run() {
		
		data.odd();
		
		
	}

	
}
