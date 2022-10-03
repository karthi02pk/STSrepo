package com.example.demo;

public class Testtt {

	public static void main(String[] args) {

		String input = "G00gle";
		int result= 0;
		int element = 0;
		for(int i = 0;i<input.length();i++) {
			try {
				 element= Integer.parseInt(input.charAt(i)+"");
				result++;
			}
			catch(Exception e) {
				
			}
		}
		System.out.println(result);
	}

}
