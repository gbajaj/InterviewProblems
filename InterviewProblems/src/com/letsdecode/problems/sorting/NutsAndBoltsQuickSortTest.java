package com.letsdecode.problems.sorting;

import org.junit.Assert;
import org.junit.Test;

public class NutsAndBoltsQuickSortTest {

	@Test
	public void test() {
		char[] nuts = { '$', '%', '#' };
		char[] bolts = { '%', '$', '#' };
		NutsAndBoltsQuickSort nutsAndBoltsQuickSort = new NutsAndBoltsQuickSort(nuts,
				bolts);
		nutsAndBoltsQuickSort.call();
		
		Assert.assertEquals(nutsAndBoltsQuickSort.resBolts.length,
				nutsAndBoltsQuickSort.resNuts.length);
		Assert.assertEquals(true, isEqual(nutsAndBoltsQuickSort.resBolts, nutsAndBoltsQuickSort.resNuts));

	}

	boolean isEqual(char[] arr1, char[] arr2) {
		int i = 0, j = 0;
		for (; i < arr1.length && j < arr2.length; i++, j++) {
			if (arr1[i] != arr2[j]) {
				return false;
			}
		}
		if (i < arr1.length || j < arr2.length) {
			return false;
		}
		return true;
	}

}
