package com.letsdecode.problems.graph.cycledetection.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CourseSchduleDiGraphTest {

	@Test
	public void test() {
		CourseSchduleDiGraph g = new CourseSchduleDiGraph();
		// int[][] pre = { { 1, 0 } };
		// Assert.assertTrue(g.canFinish(2, pre));
		//
		// int[][] pre1 = { { 0, 1 } };
		// Assert.assertTrue(g.canFinish(2, pre1));
		//
		// int[][] pre2 = { { 1, 0 }, { 0, 1 } };
		// Assert.assertFalse(g.canFinish(2, pre2));

		// int[][] pre3 = { { 3, 0 }, { 0, 1 } };
		// Assert.assertTrue(g.canFinish(4, pre3));

		int[][] pre4 = { { 1, 0 }, { 2, 0 }, { 0, 2 } };
		Assert.assertFalse(g.canFinish(3, pre4));

	}
}
