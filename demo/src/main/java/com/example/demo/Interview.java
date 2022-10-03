package com.example.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {

public static void main(String[] args) {
	String input = "aabbaaaaccdeeeeeef";
	String element;
	int occurence=1;
	HashMap< String, Integer> hm = new HashMap<>();

	for(int i = 0 ; i<input.length();i++) {
		element = input.charAt(i)+"";
		for(int j=i+1;j<input.length();j++) {
			if(element.equals(input.charAt(j)+"")) {
				occurence++;
			}else {
				break;
			}
		}
		if(hm.containsKey(element)) {
			int value=hm.get(element);
			if(occurence>value)
				hm.put(element, occurence);
		}else {
		hm.put(element, occurence);
		}
		occurence=1;
	}
	
	System.out.println(hm.values().stream().mapToInt(e->(e)).summaryStatistics().getMax());
}
	
}
