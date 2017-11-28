package com.letsdecode.problems.leetcode;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayProblemsTest {

	@Test
	public void test() {
		int a[] = { 1, 2, 3, 4 };
		int res[] = new ArrayProblems().productOfArrayExceptSelf(a);
		print(res);
	}

	@Test
	public void testBestTimeToBuyAndSellStock() {
		int a[] = { 7, 6, 4, 3, 1 };
		int res = new ArrayProblems().bestTimeToBuyAndSellStock(a);
		System.out.println(res);
	}

	@Test
	public void testProductOTwoArrays() {
		String a = "999";
		String b = "9999";
		String result = new ArrayProblems().productOfTwoArrays(a, b);
		System.out.println(result);
	}

	@Test
	public void testBoardGameWinnable() {
		// int [] a = {2,3,1,1,4};
		int[] a = { 3, 2, 1, 0, 4 };
		boolean result = new ArrayProblems().boardGameWinnable(a);
		System.out.println(result);
	}

	@Test
	public void removeElement() {
		int[] a = { 3, 2, 2, 2, 3 };
		int res = new ArrayProblems().removeElement(a, 3);
		System.out.println(res);
	}

	@Test
	public void testBestTimeToBuyAndSellStock2() {
		int a[] = { 4, 3, 5, 8 };
		int res = new ArrayProblems().bestTimeToBuyAndSellStock2(a);
		System.out.println(res);
	}

	@Test
	public void testNationalDutchFlag() {
		// int a[] = { 2, 5, 8, 9, 5, 3, 1 };
		int a[] = { 2, 2, 2, 2, 0, 0, 0, 1, 1, 1 };
		new ArrayProblems().dutchFlag(a, 1);
		print(a);
	}

	@Test
	public void incrementABigInteger() {
		// byte a[] = { 9, 9, 9 };
		byte a[] = { 9, 0, 0 };
		byte[] out = new ArrayProblems().incrementABigInteger(a);
		print(out);
	}

	@Test
	public void firstMissingPositive() {
		// byte a[] = { 9, 9, 9 };
		int a[] = { 3, 4, -1, 2 };
		int res = new ArrayProblems().firstMissingPositive(a);
		System.out.println(res);
	}

	@Test
	public void maxProfit() {
		// int a[] = { 1,2,4,2,5,7,2,4,9,0};
		int a[] = { 1, 2, 4, 2, 5, 7, 2, 4, 9 };
		int res = new ArrayProblems().maxProfit(a);
		System.out.println(res);
	}

	public void print(byte[] a) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void print(int[] a) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	@Test
	public void fourSum() {
		//
		// int a[] = { 1, 0, -1, 0, -2, 2 };
		int a[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = new ArrayProblems().fourSum(a, 0);
		System.out.println(res);
	}

	@Test
	public void threeSum() {
		//
		int a[] = { -1, 0, 1, 2, -1, -4 };
		// int a[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = new ArrayProblems().threeSum(a);
		System.out.println(res);
	}

	@Test
	public void permute() {
		//
		int a[] = { 1, 2, 3 };
		// int a[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = new ArrayProblems().permute(a);
		System.out.println(res);
	}

	@Test
	public void combinationSum3() {
		//
		// int a[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = new ArrayProblems().combinationSum3(3, 15);
		System.out.println(res);
	}

	@Test
	public void subsetsWithDup() {
		//
		int a[] = { 1, 2, 2 };
		List<List<Integer>> res = new ArrayProblems().subsetsWithDup(a);
		System.out.println(res);
	}

	@Test
	public void removeDuplicates() {
		//
		int a[] = { 1, 1, 1, 2, 2, 3 };
		int res = new ArrayProblems().removeDuplicates(a);
		System.out.println(res);
	}

	@Test
	public void findShortestWay() {
		//
		int maze[][] = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		int[] ball = { 4, 3 };
		int[] hole = { 3, 0 };
		String res = new ArrayProblems().findShortestWay(maze, ball, hole);
		System.out.println(res);
	}

	@Test
	public void spiralOrder() {
//		int a[][] = { { 2, 3 } };
//		int a[][] = { { 2}, { 3 }, { 1 } };
		int a[][] = { {1,2,3}, {4,5,6}, {7, 8,9} };
		System.out.println(new ArrayProblems().spiralOrder(a));
	}

	@Test
	public void generateMatrix() {
//		int a[][] = { { 2, 3 } };
//		int a[][] = { { 2}, { 3 }, { 1 } };
		int a[][] = { {1,2,3}, {4,5,6}, {7, 8,9} };
		System.out.println(new ArrayProblems().generateMatrix(2));
	}
	
	@Test
	public void combinationSum() {
//		int a[][] = {{ 2,3,6,7}, {7}};
		int a[][] = {{ 1, 1}, {2}};
		System.out.println(new ArrayProblems().combinationSum(a[0], a[1][0]));
	}
	@Test
	public void candy() {
		int a[] = { 1, 2, 6, 1};
		System.out.println(new ArrayProblems().candy(a));
	}

	@Test
	public void combinationSum3_() {
		System.out.println(new ArrayProblems().combinationSum3_(3, 7));
	}
	
	@Test
	public void productExceptSelf() {
		int a[][] = {{ 0, 0}, {2}};
		System.out.println(new ArrayProblems().productExceptSelf(a[0]));
	}

	@Test
	public void testDate() throws ParseException {
		int a[][] = {{ 0, 0}, {2}};
		new ArrayProblems().testDate();
	}

	
}
