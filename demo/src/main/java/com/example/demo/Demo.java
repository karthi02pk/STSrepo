package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {

	 public static int solution(int[] A) {
		  Arrays.parallelSort(A);
	      List<Integer> intList = new ArrayList<>();
	      Predicate<Integer> pred = (i) ->i>0;
	      for(int a : A){
	          intList.add(a);
	      }
	      int count = (int) intList.stream().filter(pred).count();
	      if(count==0)
	    	  return 1;
	      for(int i : intList) {
	    	  int element = i;
	    	  if(intList.contains(element+1)) {
	    		 continue; 
	    	  }else {
	    		  return element+1;
	    	  }  
	      }
	      return 0;
	    }
	 
	 public static String[] dice(int[] A , int F , int M) {
		
		 Map<String,Integer> mp = new HashMap<>();
		 String [] result = null;
		 int invalidcount=0;
		 int totalcount= A.length + F;
		 int sum=0;
		 StringBuffer start = new StringBuffer();
		 StringBuffer end = new StringBuffer();
			/* java SE-8 */
		 Predicate<Integer> pred = (i) ->{
				char[] str=String.valueOf(i).toCharArray();
				for(char a : str) {
					if(Integer.parseInt(a+"")==0 || Integer.parseInt(a+"")>6)
						return false;
				}
				return true;
			 };
			 List<Integer> lst = new ArrayList<>();
			 /* java SE-8 */
		 for(int i=1;i<=F;i++) {
			 start.append(1);
			 end.append(6);
		 }
		 /* java SE-8 */
		 for(int i=Integer.parseInt(start.toString());i<=Integer.parseInt(end.toString());i++) {
			 lst.add(i);
		 }
		List l = lst.stream().filter(pred).collect(Collectors.toList());
		 /* java SE-8 */
		 for(int i=Integer.parseInt(start.toString());i<=Integer.parseInt(end.toString());i++) {
			 String val = String.valueOf(i);
			 char [] arr = val.toCharArray();
			 int total=0;
			 boolean flag=true;
			 for(int j=0;j<arr.length;j++) {
				 if(Integer.parseInt(arr[j]+"")>6 || Integer.parseInt(arr[j]+"")==0 ) {
					 flag= false;
					 break;
				 }else
					 total=total+Integer.parseInt(arr[j]+"");
			 }
			 if(flag)
				 mp.put(i+"",total);
		 }
		 
			/*
			 * for (int i = 1; i <= 6; i++) { for (int j = 1; j <= 6; j++) { mp.put(i+"-"+j,
			 * i+j); } }
			 */
				
			
		 for(int i=0;i<A.length;i++) {
			 sum = sum+A[i];
		 }
		 for(Map.Entry<String,Integer> entrys : mp.entrySet()) {
			 if((sum+ entrys.getValue()) /totalcount ==M) {
				String res = entrys.getKey();
				return res.split("-");
			 }else {
				 invalidcount++;
			 }
		 }
		 if(invalidcount == mp.size())
			 return new String[] {"0"};
		 
		return result; 
	 }

	public static void main(String[] args) {
		int arr[] = {3,2,4,3};
		//System.out.println(solution(arr));
	//	System.out.print("H" + "a");
		//System.out.print('H' + 'a');
		//A a= new A();
		dice(arr,2,4);
	}

}

