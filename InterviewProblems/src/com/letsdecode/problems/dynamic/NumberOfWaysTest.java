package com.letsdecode.problems.dynamic;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfWaysTest {

	@Test
	public void test() {
		int[] set = { 1, 5 };
		int target = 5;
		NumberOfWays numberOfWays = new NumberOfWays(target, set);
		System.out.println(numberOfWays.numberOfWaysByRecursion(numberOfWays.n));
	}

}
