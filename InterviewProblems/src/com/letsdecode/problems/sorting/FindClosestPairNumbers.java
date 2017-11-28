package com.letsdecode.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;

import com.letsdecode.problems.quickSortIntArray;

public class FindClosestPairNumbers {
	int[] a;
	public ArrayList<Integer> list = new ArrayList();;
	public int res = Integer.MAX_VALUE;

	public FindClosestPairNumbers(int[] a) {
		this.a = a;
	}

	public void call() {
		Arrays.sort(a);
		findPair(a, 0, a.length - 1);

	}

	private void findPair(int[] a, int l, int h) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {

			int dis = Math.abs(( a[i + 1] - a[i]));
			if (dis  == min) {
				list.add(a[i]);
				list.add(a[i + 1]);
			} else if (dis  < min) {
				min = dis;
				list.clear();
				list.add(a[i]);
				list.add(a[i + 1]);
			}
		}
	}
}
