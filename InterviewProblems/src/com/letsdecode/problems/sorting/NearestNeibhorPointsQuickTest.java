package com.letsdecode.problems.sorting;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.letsdecode.problems.sorting.NearestNeibhorPointsQuick.Neighbor;

public class NearestNeibhorPointsQuickTest {

	@Test
	public void test() {
		int[][] p = { { 2, 3 }, { 12, 30 }, { 40, 50 }, { 5, 1 }, { 12, 10 },
				{ 3, 4 } };
		Point distFrom = new Point(4, 5);
		Neighbor[] points = new NearestNeibhorPointsQuick.Neighbor[p.length];
		for (int i = 0; i < p.length; i++) {
			points[i] = new Neighbor(p[i][0], p[i][1], distFrom);
		}

		NearestNeibhorPointsQuick n = new NearestNeibhorPointsQuick(points, distFrom, 4);
		n.call();
		Point [] res = n.getResult();
		int lent  = res.length;
	}
}
