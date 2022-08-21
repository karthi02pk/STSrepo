package com.example.demo;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.Aspectconfig;


public class Test {

public void one() {
	System.out.println("one()");
}
public String two() {
	System.out.println("two()");
	return "two";
}

public void serializedeserialize() {

	  String[] str = "test first letter".split(" ");
	  Info i = new Info(2, "test");
	  
	  try {
		  ObjectOutputStream oos = new ObjectOutputStream(new
	      FileOutputStream("D:\\SpringbootApp\\test.txt"));
		  oos.writeObject(i);
	      oos.close();
	      ObjectInputStream ois =new ObjectInputStream(new
	      FileInputStream("D:\\SpringbootApp\\test.txt"));
	      Info ii = (Info)
	      ois.readObject();
	      System.out.println(ii.getId()+"-"+ii.getName());
	      ois.close(); 
	  }
	  catch (Exception e) { 
		  e.printStackTrace();
		  }
	  
}
public void Streamfunc() {

	 String str="aaccgnnkuu";
	  Map m = new LinkedHashMap<>(); 
	  Character c = str.chars().mapToObj(e ->Character.toLowerCase(Character.valueOf(((char) e))))
	  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
	  Collectors.counting())).entrySet() .stream().filter(e -> e.getValue() ==
	  1L).map(e -> e.getKey()).findFirst().get(); 
	  System.out.println(c);
	  
	  
	  List <Info> infolist = new ArrayList<>();
	  int[] list = {5,1,3,8,6,3,1};
	  char [] strarr= "deac".toCharArray();
	  infolist.add(new Info(2,"def"));
	  infolist.add(new Info(1,"abc")); infolist.add(new Info(4,"123"));
	  infolist.add(new Info(5,"456")); infolist.add(new Info(3,"ghi"));
	  
	  Info first = infolist.stream().min((I1,I2)->I1.getId()>I2.getId() ? 1:-1).get();
	  Info last = infolist.stream().max((I1,I2)->I1.getId()>I2.getId()? 1 :-1).get();
	  System.out.println(first.getId()+"--"+last.getId());
	  infolist.forEach((info)->{ System.out.println(info.getId()); }); 
	  long cnt = infolist.stream().filter((inf)->inf.getId()>2).count();
	  
	  Map<Object, Object>i=infolist.stream().collect(Collectors.toMap(e->e.getId(),(e)->e.getName()));
	  List k=infolist.stream().filter((e)->e.getId()>3).map((e)->e.getId()+"-"+e.getName()).collect(Collectors.toList());
	  Integer j=infolist.stream().filter((e)->e.getId()>1).map((e)->e.getId()).collect(Collectors.summingInt((e)->e));
	  
	  
	  Arrays.parallelSort(strarr);
	  for (char i1 : strarr) {
		  System.out.print(" "+i1);
	  } 
	  
	  Arrays.parallelSort(list); 
	  for (int i2 : list) {
		  System.out.print(" "+i2); 
		  } 
	  
	//  System.out.println(list.stream().sorted().collect(Collectors.toList()));
	 
}

public void funcInterfaces() {
	

	  //Predicate
	  Predicate<Integer> pred= (e)->e==1;
	  System.out.println(pred.negate().test(2));
	  
	  //Consumer
	  Consumer<Integer> con = (a)->{
	  a=2*a; System.out.println(a); 
	  }; 
	  
	  Consumer<Integer> consumer = (a)->{
	  System.out.println("andthn-"+a);
	  };
      con.andThen(consumer).accept(3);
      Supplier<Double>s= ()-> Math.random(); 
      System.out.println(s.get());
	  
      //BiFunction
	  BiFunction<Integer, Integer, Integer> bi = (a,b)->a+b;
	  System.out.println(bi.apply(3, 4));
	  System.out.println(bi.andThen(c->c+1).apply(3, 5));
	 
}



public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.register(Aspectconfig.class);
	context.refresh();
	
	Test t = context.getBean(Test.class);
	t.one();
	t.two();
	
	
	
//	new Test().funcInterfaces();
	
	 
	/*
	 * StringBuffer sb = new StringBuffer(); for(String word : str) {
	 * sb.append(word.replaceFirst(word.charAt(0)+"",
	 * (word.charAt(0)+"").toUpperCase())); sb.append(" "); }
	 * System.out.println(sb.toString());
	 */
	
	
		 }
}
