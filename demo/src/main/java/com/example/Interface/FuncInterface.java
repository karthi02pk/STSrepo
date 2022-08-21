package com.example.Interface;

@FunctionalInterface
public interface FuncInterface {

	void add();
	default void sub() {
		System.out.println("default method");
	}
	default void sub1() {
		System.out.println("default method");
	}
	static void test() {
		System.out.println("static method");
	}
	static void test1() {
		System.out.println("static method");
	}
}
