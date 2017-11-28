package com.letsdecode.problems.sorting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KNearestNeighorsTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testCall() {
		int arr[] = { 11, 1, 4, 6, 8, 9, 3, 2, 12, 25, 18, 90, 20, 50 };
		KNearestNeighors kNearestNeighors = new KNearestNeighors(arr, 11, 4);
		kNearestNeighors.call();
		int element = kNearestNeighors.getResult();
		Assert.assertEquals(4, element);

	}

	@Test
	public void testCreateCopy() {

	}

}
