package com.letsdecode.problems.sorting;

public class KNearestNeighors {

	int[] arr;
	int k;
	int val; // value to find nearest from
	int result;

	public KNearestNeighors(int[] arr, int val, int k) {
		this.arr = arr;
		this.k = k - 1;
		this.val = val;
	}

	public int getResult() {
		return result;
	}

	public void call() {
		quicksort(arr, 0, arr.length - 1, val);
	}

	private void quicksort(int[] a, int l, int h, int val) {
		if (l < h && k >= 0 || k <= h) {
			int i = partition(a, l, h, val);
			if (i == k) {
				result = a[k];
				return;
			}
			if (i < k) {
				quicksort(a, i + 1, h, val);
			} else {
				quicksort(a, l, i - 1, val);
			}
		}
	}

	private int partition(int[] a, int l, int h, int val) {
		int mid = l + (h - l) / 2;
		int pivot = a[mid];
		while (l < h) {
			while (l < h && a[l] <= pivot) {
				l++;
			}
			while (l < h && a[h] >= pivot) {
				h--;
			}
			if (l < h) {
				swap(a, l, h);
				l++;
				h--;
			}
		}
		swap(a, l, mid);
		return l;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	int[] createCopy(int[] a, int i, int j) {
		if (j < i)
			return null;
		int len = j - i + 1;
		int[] res = new int[len];
		for (int k = 0; k < len; k++) {
			res[k] = a[i];
			i++;
		}
		return res;
	}
}
