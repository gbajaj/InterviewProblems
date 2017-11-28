package com.letsdecode.problems;

public class quickSortIntArray {
	public int[] a;

	public quickSortIntArray(final int[] a) {
		this.a = a;
	}

	public void call() {
		quickSort(a, 0, a.length - 1);
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	void quickSort(final int a[], int i, int j) {
		if (i < j) {
			int index = partition(a, i, j);
			quickSort(a, i, index - 1);
			quickSort(a, index + 1, j);
		}

	}

	int partitionOrig(final int a[], int i, int j) {
		int pivot = a[i];
		int start = i;
		int k = i;

		for (; k <= j; k++) {
			if (a[k] < pivot) {
				swap(a, k, i + 1);
				i++;
			}
		}
		swap(a, start, i);
		return i;
	}

	int partition(final int a[], int i, int j) {
		int mid = i + (j - i) / 2;
		int pivot = a[mid];
		while (i < j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i < j) {
				swap(a, i, j);
			}
		}
		return i;
	}

	/**
	 * this is also called the ranking alogrithm
	 * 
	 * @param a
	 * @param i
	 */
	public void partitionByIndex(int a[], int i) {
		if (i < 0 || i > a.length)
			throw new ArrayIndexOutOfBoundsException();

		int pivot = a[i];
		int s = 0;
		int e = a.length - 1;
		while (s < e) {
			while (a[s] < pivot) {
				s++;
			}

			while (a[e] > pivot) {
				e--;
			}
			if (s < e) {
				swap(a, s, e);
			}
		}

	}

}
