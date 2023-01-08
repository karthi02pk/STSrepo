package com.example.demo;

public class Testtt {

	public static int test(int [] A , int x) {
		if(A.length==0)
			return -1;
		
		int l=0;
		int r=A.length;
		while(l<r) {
			int m= (l+r)/2;
			if(A[m]< x) {
				r=m-1;
			}else {
				l=m;
			}
		if(A[l]==x)		
			return l;
				
		}
		
		
		return -1;
	}
	public static void main(String[] args) { 
		System.out.println(test(new int[]{1,8,5,9,10},8));
	}

}
