package com.letsdecode.problems.dynamic;

public class NumberOfWays {
	int n;
	int set[] = { 0 };

	public NumberOfWays(int n, int[] set) {
		this.n = n;
		this.set = set;
	}

	/*
	 * Recursive Approach
	 */

	public int numberOfWaysByRecursion(int target) {
		int retVal = 0;
		for (int i = 0; i < set.length; i++) {
			int newTarget = target - set[i];
			if (newTarget == 0) {
				retVal += 1;
				return retVal;
			} else if (newTarget > 0) {
				retVal += numberOfWaysByRecursion(newTarget);
			}
		}
		return retVal;

	}
}
