package com.letsdecode.problems.arrays;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.arrays.ArrayProblems.Interval;
import com.letsdecode.problems.arrays.ArrayProblems.RandomizedCollection;
import com.letsdecode.problems.helper.Arrays;

public class ArrayProblemsTest {

	@Test
	public void test() {
		int actual = 0;
		int input[] = null;
		int out = 0;
		int a[] = { 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 };
		input = a;
		out = new ArrayProblems().findContigousSubarrayOf0sAnd1s(input, 1);
		Assert.assertEquals(out, 6);

		int c[] = { 0, 0 };
		input = c;
		actual = new ArrayProblems().findContigousSubarrayOf0sAnd1s(input, 1);
		Assert.assertEquals(0, actual);

		int d[] = { 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 };
		input = d;
		int k = 2;
		out = new ArrayProblems().findContigousSubarrayOf0sAnd1s(input, k);
		Assert.assertEquals(out, 8);

	}

	@Test
	public void testTappingWater() {
		// int [] a = {0,1,0,2,1,0,1,3,2,1,2,1};
		// int [] a = {0,1,0,1};
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3 };
		System.out.println(new ArrayProblems().tappingRainWater(a));
	}

	@Test
	public void findClosestToZero() {
		int[] a = { 15, 18, 30 };
		Assert.assertEquals(33, new ArrayProblems().findClosestToZero(a));

		int[] b = { -7, -10, 6 };
		Assert.assertEquals(-1, new ArrayProblems().findClosestToZero(b));
	}

	@Test
	public void findClosestToZeroWithSortedArray() {
		int[] a = { -100, -50, -30 };
		Assert.assertEquals(-80,
				new ArrayProblems().findClosestToZeroWithSortedArray(a));

		int[] b = { 1, 4, 6, 8, 45, 78, };
		Assert.assertEquals(5, new ArrayProblems().findClosestToZero(b));
		int[] c = { -100, -80, -20, -5, 6, 10, 30, 67 };
		Assert.assertEquals(1, new ArrayProblems().findClosestToZero(c));
	}

	@Test
	public void printMatrixDiagonals() {
		int a[][] = { { 9, 8, 4 }, { 6, 7, 4 } };
		// int a[][] = { { 9, 8}, { 6, 7} };
		// int a[][] = { { 9}};
		// int a[][] = { { 9, 8}};

		ArrayProblems ap = new ArrayProblems();
		ap.printMatrixDiagonals(a);

	}

	@Test
	public void arrangeCoins() {
		ArrayProblems ap = new ArrayProblems();
		ap.arrangeCoins(1804289383);
	}

	@Test
	public void searchRange() {
		ArrayProblems ap = new ArrayProblems();
		// int []a = {1, 2, 3, 3, 3, 4, 5, 7};
		int[] a = { 1, 3 };
		int t = 2;
		ap.searchRange(a, t);
	}

	@Test
	public void merge() {
		ArrayProblems ap = new ArrayProblems();
		// Test 1
		String[][] input = new String[][] { { "1", "3" }, { "2", "6" },
				{ "8", "10" }, { "15", "18" } };
		String[][] expecteda = new String[][] { { "1", "6" }, { "8", "10" },
				{ "15", "18" } };
		List<Interval> expected = getIntervalList(expecteda);
		List<Interval> actual = ap.merge(getIntervalList(input));
		System.out.println(isResultValid(actual, expected));

		// Test 1
		input = new String[][] { { "1", "4" }, { "2", "3" }, { "8", "10" },
				{ "15", "18" } };
		expecteda = new String[][] { { "1", "4" }, { "8", "10" },
				{ "15", "18" } };
		expected = getIntervalList(expecteda);
		actual = ap.merge(getIntervalList(input));
		System.out.println(isResultValid(actual, expected));

	}

	List<Interval> getIntervalList(String[][] in) {
		List<Interval> list = new ArrayList<>();
		ArrayProblems ap = new ArrayProblems();
		for (String[] t : in) {
			Interval a = ap.new Interval(Integer.parseInt(t[0]),
					Integer.parseInt(t[1]));
			list.add(a);
		}
		return list;

	}

	boolean isResultValid(List<Interval> actual, List<Interval> expected) {
		if (actual.size() == expected.size()) {
			for (int i = 0; i < actual.size(); i++) {
				if (actual.get(i).start != expected.get(i).start
						|| actual.get(i).end != expected.get(i).end) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Test
	public void combine() {
		ArrayProblems ap = new ArrayProblems();
		System.out.println(ap.combine(4, 2));
	}

	@Test
	public void sumRange() {
		ArrayProblems ap = new ArrayProblems();
		int[] a = { -2, 0, 3, -5, 2, -1 };
		ap.NumArray(a);
		System.out.println(ap.sumRange(0, 2));

	}

	@Test
	public void totalHammingDistance() {
		ArrayProblems ap = new ArrayProblems();
		// int[] a = { 4, 14, 2 };
		int[] a = { 6, 1 };
		System.out.println(ap.totalHammingDistance(a));

	}

	@Test
	public void containsNearbyAlmostDuplicate() {
		ArrayProblems ap = new ArrayProblems();
		// int[] a = { 4, 14, 2 };
		// int[] a = {-1, -1};
		// int[] a = {1, 3, 1};
		int[] a = { 3, 6, 0, 4 };

		// int[] a = {1, 2};
		// int[] a = {7, 2, 8};
		System.out.println(ap.containsNearbyAlmostDuplicate(a, 2, 2));
	}

	@Test
	public void findTarget() {
		ArrayProblems ap = new ArrayProblems();
		int[] a = { 1, 1, 1, 1, 1 };
		System.out.println(ap.findTarget(a, 3));
	}

	@Test
	public void subSet() {
		ArrayProblems ap = new ArrayProblems();
		int[] a = { 4, 6, 7, 7 };
		System.out.println(ap.subSet(a));
	}

	@Test
	public void random() {
		RandomizedCollection ap = new ArrayProblems.RandomizedCollection();
		ap.insert(1);
		ap.insert(1);
		ap.insert(2);
		ap.insert(1);
		ap.insert(2);
		ap.insert(2);

		ap.remove(1);
		ap.remove(2);
		ap.remove(2);
		ap.remove(2);

	}

	@Test
	public void prettyPrint() {
		ArrayProblems ap = new ArrayProblems();
		ArrayList<ArrayList<Integer>> o = ap.prettyPrint(2);
		for (int i = 0; i < o.size(); i++) {
			for (int j = 0; j < o.get(i).size(); j++) {
				System.out.print(o.get(i).get(j));
			}
			System.out.println("");
		}

	}

	@Test
	public void kthsmallest() {
		ArrayProblems ap = new ArrayProblems();
		Integer A[] = { 1, 4, 3, 2 };
		ArrayList<Integer> array = new ArrayList();
		for (int i = 0; i < A.length; i++) {
			array.add(A[i]);
		}
		System.out.println(ap.kthsmallest(array, 2));

	}
	@Test
	public void permute() {
		ArrayProblems ap = new ArrayProblems();
		Integer A[] = { 0, 0, 0, 1, 9};
		ArrayList<Integer> array = new ArrayList();
		for (int i = 0; i < A.length; i++) {
			array.add(A[i]);
		}
		System.out.println(ap.permute(array));

	}
	
}
