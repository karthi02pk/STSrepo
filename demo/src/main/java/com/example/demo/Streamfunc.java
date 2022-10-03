package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.pojo.Employee;

public class Streamfunc {

	public static void main(String[] args) {
		/*
		 * List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13); List<Integer>
		 * OddNumbers = Arrays.asList(1, 3, 5); List<Integer> EvenNumbers =
		 * Arrays.asList(2, 4, 6, 8); List<List<Integer>> listOfListofInts
		 * =Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
		 */
    //    System.out.println(listOfListofInts.stream().flatMap(list->list.stream()).collect(Collectors.toList()));
//PrimeNumbers.stream().flatMap(e->Stream.of(e)).forEach(System.out::println);
		List<Employee> emplist = new ArrayList<>();
		emplist.add(new Employee(1, "a", "10", "x"));
		emplist.add(new Employee(2, "b", "100", "x"));
		emplist.add(new Employee(3, "c", "1000", "x"));

}
}
