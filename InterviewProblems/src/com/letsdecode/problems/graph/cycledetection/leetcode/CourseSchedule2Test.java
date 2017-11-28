package com.letsdecode.problems.graph.cycledetection.leetcode;

import org.junit.Test;

public class CourseSchedule2Test {

	@Test
	public void test() {
		CourseSchedule2 g = new CourseSchedule2();

		int[][] pre3 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] res = g.findOrder(4, pre3);
		System.out.println(res);
	}
}
