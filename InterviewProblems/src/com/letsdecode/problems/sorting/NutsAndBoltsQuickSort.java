package com.letsdecode.problems.sorting;

public class NutsAndBoltsQuickSort {
	char[] nuts;
	char[] bolts;
	public char[] resNuts;
	public char[] resBolts;

	public NutsAndBoltsQuickSort(char[] nuts, char[] bolts) {

		this.nuts = nuts;
		this.bolts = bolts;
	}

	public void call() {

		resNuts = nuts;
		resBolts = bolts;
		quicksort(nuts, bolts, 0, nuts.length - 1);
	}

	private void quicksort(char[] nuts, char[] bolts, int l, int h) {
		if (l < h) {
			int mid = l + (h - l) / 2;
			int pivot = partition(bolts, l, h, nuts[mid]);
			partition(nuts, l, h, bolts[pivot]);
			quicksort(nuts, bolts, l, pivot - 1);
			quicksort(nuts, bolts, pivot + 1, h);
		}
	}

	private int partition(char[] a, int l, int h, char pivot) {
		int mid = l + (h - l) / 2;
		while (l < h) {
			while (l < h && a[l] <= pivot) {
				if (a[l] == pivot) {
					swap(a, l, mid);
				}
				l++;
			}
			while (l < h && a[h] >= pivot) {
				if (a[h] == pivot) {
					swap(a, h, mid);
				}
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
//
//	private int partition(char[] a, int l, int h, char pivot) {
//		int mid = l + (h - l) / 2;
//		while (l < h) {
//			while (l < h && a[l] <= pivot) {
//				if (a[l] == pivot) {
//					swap(a, l, mid);
//				}
//				l++;
//			}
//			while (l < h && a[h] >= pivot) {
//				if (a[h] == pivot) {
//					swap(a, h, mid);
//				}
//				h--;
//			}
//			if (l < h) {
//				swap(a, l, h);
//				l++;
//				h--;
//			}
//		}
//		swap(a, l, mid);
//		return l;
//
//	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
