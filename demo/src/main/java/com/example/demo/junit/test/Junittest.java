package com.example.demo.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Junittest {

	@Test
	public void testJunit() {
		String str="A";
		assertEquals("a", str);
		assertEquals("A", str);
	}
}
