package com.letsdecode.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class WalmartQuestionTest {

	@Test
	public void test() {
//		int a[] = { 4, 3, 2, 1, 1 };
//		int a[] = { 1, 5, 4, 2, 1, 3 };
		int a[] = { 1, 5, 4, 2, 1, 3 };
		System.out.println(new WalmartQuestion().findSolutions(a, 4));

	}

}
