package com.letsdecode.problems.sorting;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NearestNeibhorPointsHeap {
	Point[] points;
	Point p;
	Point[] result;
	int k;

	public NearestNeibhorPointsHeap(Point[] points, Point p, int k) {
		this.points = points;
		this.p = p;
	}

	public Point[] getResult() {
		return result;
	}

	public void call () {
		PriorityQueue<Point> q = new PriorityQueue<>(points.length, new NeighborDistance());
		q.addAll(Arrays.asList(points));
		result = new Point[k];
		for (int i = 0; i< q.size() && i< points.length; i++) {
			result[i] = q.poll();
		}
	}

	class NeighborDistance implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			double dist1 = p.distance(o1);
			double dist2 = p.distance(o2);

			if (dist1 < dist2)
				return -1;
			if (dist1 > dist2)
				return 1;
			return 0;
		}

	}
}
