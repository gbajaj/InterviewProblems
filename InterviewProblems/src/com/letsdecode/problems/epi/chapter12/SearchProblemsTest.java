package com.letsdecode.problems.epi.chapter12;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchProblemsTest {

	@Test
	public void test() {
		SearchProblems sp = new SearchProblems();
		int a[] = {1, 3, 5, 5, 7,7,7,7,7, 8, 9};
		assertEquals(2, sp.firstOccuranceOfKey(a, 5));
		assertEquals(0, sp.firstOccuranceOfKey(a, 1));
		assertEquals(4, sp.firstOccuranceOfKey(a, 7));
		assertEquals(10, sp.firstOccuranceOfKey(a, 9));
	}

}
