package com.letsdecode.problems.sorting;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.helper.Arrays;

public class FindClosestPairNumbersTest {

	@Test
	public void test() {
		String s = "-20 -39697 4567 45567 30 35 40 56677 334 445";
		s = s.trim();
		String[] arr = s.split(" ");

		int a[] = Arrays.toArray(arr);

		FindClosestPairNumbers findClosestPairNumbers = new FindClosestPairNumbers(
				a);
		findClosestPairNumbers.call();
		int[] expected = { 30, 35, 35, 40 };
		int[] actuals = Arrays.toArrays(findClosestPairNumbers.list);

		Assert.assertArrayEquals(expected, actuals);
	}

}
