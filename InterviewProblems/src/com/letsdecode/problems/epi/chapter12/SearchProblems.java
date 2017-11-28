package com.letsdecode.problems.epi.chapter12;

public class SearchProblems {
	public int firstOccuranceOfKey(int[] a, int key) {
		int res = -1;
		int i = 0;
		int j = a.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (a[mid] < key) {
				i = i + 1;
			} else if (a[mid] > key) {
				j = mid - 1;
			} else {
				res = mid;
				j = mid - 1;
			}

		}
		return res;
	}
}
