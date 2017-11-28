package com.letsdecode.problems.sorting;

import java.awt.Point;

public class NearestNeibhorPointsQuick {
	public static class Neighbor extends Point {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Neighbor(int x, int y, Point distFrom) {
			super(x, y);
			double d = (this.distance(distFrom));
			num = (int) (d * d);
		}

		public final int num;
	}

	Neighbor[] points;
	Neighbor p;
	Point[] result;
	int k;

	public NearestNeibhorPointsQuick(Neighbor[] arr, Point val, int k) {
		this.points = arr;
		this.k = k - 1;
	}

	public Point[] getResult() {
		return result;
	}

	public void call() {
		int[][] p = { { 2, 3 }, { 12, 30 }, { 40, 50 }, { 5, 1 }, { 12, 10 },
				{ 3, 4 } };
		quicksort(points, 0, points.length - 1);
	}

	private void quicksort(Neighbor[] a, int l, int h) {
		if (l < h && k >= 0 || k <= h) {
			int i = partition(a, l, h);
			if (i == k) {
				result = createCopy(points, 0, k);
				return;
			}
			if (i < k) {
				quicksort(a, i + 1, h);
			} else {
				quicksort(a, l, i - 1);
			}
		}
	}

	private int partition(Neighbor[] a, int l, int h) {
		int mid = l + (h - l) / 2;
		int pivot = a[mid].num;
		while (l < h) {
			while (a[l].num < pivot) {
				l++;
			}
			while (a[h].num > pivot) {
				h--;
			}
			if (l < h) {
				swap(a, l, h);
			}
		}
		return l;
	}



	private void swap(Neighbor[] a, int i, int j) {
		Neighbor temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	Point[] createCopy(Neighbor[] a, int i, int j) {
		if (j < i)
			return null;
		int len = j - i + 1;
		Point[] res = new Point[len];
		for (int k = 0; k < len; k++) {
			res[k] = new Point(a[i]);
			i++;
		}
		return res;
	}
}
