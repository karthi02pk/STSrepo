package com.example.demo;

public class CustomThread extends Thread {

	@Override
	public void run() {
		
		System.out.println("Thread ::"+Thread.currentThread().getName());
	}
}
