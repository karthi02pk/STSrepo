package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class exampl {

	public static void main(String[] args) {
		
		
			String input="This This is is done by TATA TATA for TATA";
			List<String> inputlist= new ArrayList<String>();
			String [] str= input.split(" ");
			for (int i=0; i<str.length;i++){
			    inputlist.add(str[i]);
			}
		Map<String,Long> map=	inputlist.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()));
		for(Map.Entry<String,Long> e : map.entrySet()){
		    System.out.println(e.getKey()+"=>"+e.getValue());
		}
		
	//	inputlist.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting())).entrySet().forEach(e->{System.out.println(e.getKey()+""+e.getValue())});
		}
	

}
