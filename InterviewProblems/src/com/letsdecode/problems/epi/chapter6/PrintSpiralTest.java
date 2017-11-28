package com.letsdecode.problems.epi.chapter6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintSpiralTest {

	@Test
	public void test() {
		// int A[][] = { { 1 } };
		// int A[][] = { { 1,2 }, { 4,3 } };
		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new PrintSpiral().printSpiral(A);
	}

}
