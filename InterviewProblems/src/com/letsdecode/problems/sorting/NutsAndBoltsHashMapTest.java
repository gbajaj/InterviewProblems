package com.letsdecode.problems.sorting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NutsAndBoltsHashMapTest {

	@Test
	public void test() {
		char[] nuts = { '#', '$', '%' };
		char[] bolts = { '%', '$', '#' };
		NutsAndBoltsHashMap nutsAndBoltsHashMap = new NutsAndBoltsHashMap(nuts,
				bolts);
		nutsAndBoltsHashMap.call();
		
		Assert.assertEquals(nutsAndBoltsHashMap.resBolts.length,
				nutsAndBoltsHashMap.resNuts.length);
		Assert.assertEquals(true, isEqual(nutsAndBoltsHashMap.resBolts, nutsAndBoltsHashMap.resNuts));

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
