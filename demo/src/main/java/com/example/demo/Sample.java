package com.example.demo;

import com.example.Interface.FuncInterface;
import com.example.Interface.Test;

public class Sample implements FuncInterface {

	public static void main(String[] args) {
		FuncInterface Fi = () ->{
			System.out.println("***");
		};
		Fi.add();
		

		

	}

	@Override
	public void add() {
		System.out.println("add");
		
	}
 
	

	

}
