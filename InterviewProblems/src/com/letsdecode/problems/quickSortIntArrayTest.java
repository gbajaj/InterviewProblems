package com.letsdecode.problems;

import org.junit.Assert;
import org.junit.Test;

public class quickSortIntArrayTest {

	@Test
	public void test() {
		int[] a = { 7, 9, 5, 6, 3 };
		quickSortIntArray quickSortIntArray = new quickSortIntArray(a);
		quickSortIntArray.call();
		int[] res = { 3, 5, 6, 7, 9 };
		Assert.assertArrayEquals(res, a);

	}

	@Test
	public void test2() {
		int[] a = { 9, 8, 5, 4, 3 };
		quickSortIntArray quickSortIntArray = new quickSortIntArray(a);
		quickSortIntArray.call();
		int[] res = { 3, 4, 5, 8, 9 };
		Assert.assertArrayEquals(res, a);

	}

	@Test
	public void testPartitionArrayByIndex() {
		int[] a = { 9, 8, 5, 4, 3 };
		quickSortIntArray quickSortIntArray = new quickSortIntArray(a);
		quickSortIntArray.partitionByIndex(a, 2);
		Assert.assertEquals(5, a[2]);

	}

}
