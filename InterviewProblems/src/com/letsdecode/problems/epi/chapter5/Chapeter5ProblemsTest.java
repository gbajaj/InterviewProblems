package com.letsdecode.problems.epi.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapeter5ProblemsTest {

	@Test
	public void testComputeParity() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		System.out.println(chapeter5Problems.computeParity(0x777777));
	}

	@Test
	public void testDuchNationFlagProblem() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		int[] a = { 10, 4, 4, 4, 3, 5, 1, 2, 3, 7, 8, 9, 10 };
		// int[] a = { 10, 4, 4, 4, 3, 5, 1};
		chapeter5Problems.duchNationFlagProblem(a, 3);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	@Test
	public void testComputeTheMaxDifference() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		int[] a = {2,3, -1, 8};
		int diff = chapeter5Problems.computeTheMaxDifference(a);
		System.out.print(diff);

	}

	@Test
	public void test() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		System.out.println(chapeter5Problems.myPow(1.00012, 1024));

	}

	@Test
	public void testgetDecimal() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		System.out.println(chapeter5Problems.getDecimal("19", 16));
	}

	@Test
	public void testdecimalConversion() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		System.out.println(chapeter5Problems.decimalConversion(25, 16));
	}

	@Test
	public void testConvertBase() {
		Chapeter5Problems chapeter5Problems = new Chapeter5Problems();
		System.out.println(chapeter5Problems.convertBase("11001", 2, 8));

	}
}
