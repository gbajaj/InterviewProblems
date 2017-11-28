package com.letsdecode.problems.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountingSortTest {

	@Test
	public void test() {
		int a[] = {1, 5, 3, 4, 3, 5, 2};
		CountingSort sorting = new CountingSort(a);
		sorting.sort();
		int [] expected = {1, 2, 3, 3, 4, 5, 5};
		assertArrayEquals(expected, sorting.getOut());
	}

}
