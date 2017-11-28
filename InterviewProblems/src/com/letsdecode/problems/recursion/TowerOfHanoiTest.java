package com.letsdecode.problems.recursion;

import org.junit.Assert;
import org.junit.Test;

public class TowerOfHanoiTest {

	@Test
	public void test3Disks() {

		int A[] = { 3, 2, 1 };
		int expected[] = { 3, 2, 1 };
		int B[] = new int[A.length];
		int C[] = new int[A.length];

		TowerOfHanoi towerOfHanoi = new TowerOfHanoi(A, B, C, A.length);
		towerOfHanoi.call();
		int[] actual = towerOfHanoi.getResult();
		Assert.assertArrayEquals(expected, actual);

	}

	@Test
	public void test5Disks() {

		int A[] = { 5, 4, 3, 2, 1 };
		int expected[] = { 5, 4, 3, 2, 1 };

		int B[] = new int[A.length];
		int C[] = new int[A.length];

		TowerOfHanoi towerOfHanoi = new TowerOfHanoi(A, B, C, A.length);
		towerOfHanoi.call();
		int[] actual = towerOfHanoi.getResult();
		Assert.assertArrayEquals(expected, actual);

	}
}
