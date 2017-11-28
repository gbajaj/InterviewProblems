package com.letsdecode.problems.epi.chapter6;

import java.awt.geom.Point2D;

public class ElectricCar {
	/**
	 * 
	 * @param a
	 *            alternating Ascend and descending starting with ascending
	 * @return
	 */
	int findCapacity(int a[]) {
		int capacity = 0;
		int minHeight = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int height = a[i];
			capacity = Math.max(capacity, height - minHeight);
			minHeight = Math.min(minHeight,  height);

		}
		return capacity;
	}
}
