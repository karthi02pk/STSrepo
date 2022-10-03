package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;

public class Example1 {
 
	
	public static void main(String[] args) throws Exception {
		List<String> input = Arrays.asList("aaa","bbb","aaa","ccc");
		Map<String, Long> hm = input.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		IntSummaryStatistics stat = hm.values().stream().mapToInt(e->Integer.parseInt(e+"")).summaryStatistics();
		int highcount = stat.getMax();
		for(Entry<String, Long> e : hm.entrySet()) {
			if(e.getValue()==Long.parseLong(highcount+"")) {
				System.out.println(e.getKey());
			}
		}
	}

}
