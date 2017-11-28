package com.letsdecode.problems.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriesTest {

	@Test
	public void test() {
		Tries t = new Tries();
		t.insert("Gaurav");
		t.insert("Bajaj");
		
		t.insert("Jyoti");
		t.insert("Bajaj5");
		System.out.println(t.startsWith("Bajaj5"));
		t.printTries();
		
	}

	@Test
	public void buildLeetCodeTree() {
		Tries t = new Tries();
		t.insert("Gaurav");
		t.insert("Bajaj");
		
		t.insert("Jyoti");
		t.insert("Bajaj5");
		System.out.println(t.startsWith("Bajaj5"));
		t.printTries();
		
	}

	

}
