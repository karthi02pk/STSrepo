package com.example.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class data {
	public static ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)) ;
	static volatile int i=0;
	
	public static void odd() {
		try {
			synchronized (list) {
				while (i < list.size()) {
					if (i == 0) {
						System.out.println(list.get(i));
						i++;
						list.wait();
					} else if (i / 2 == 0) {
						System.out.println(list.get(i));
						i++;
						list.wait();
					} else {
						list.notify();
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void even() {
		try {
			synchronized (list) {
			while (i < list.size()) {
				if (i / 2 != 0) {
					System.out.println(list.get(i));
					i++;
					list.wait();
				} else {
					list.notify();
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
