package com.example.demo;

public class ThreadImpl {
	public static void main(String[] args) {
		try {
			/*
			 * for(int i=0;i<10;i++) { CustomThread t = new CustomThread();
			 * t.setName("Thread-"+i); t.start(); t.join(); }
			 */
			
			Thread1 t1 = new Thread1();
			Thread2 t2 = new Thread2();
			t1.start();
			t2.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
