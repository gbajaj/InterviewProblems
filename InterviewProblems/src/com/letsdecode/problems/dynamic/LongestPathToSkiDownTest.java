package com.letsdecode.problems.dynamic;

import org.junit.Test;

public class LongestPathToSkiDownTest {

	@Test
	public void test() {
		int a[][] = { { 3, 5, 3 }, { 2, 3, 4 }, { 1, 0, 1 } };
		new LongestPathToSkiDown(a).findPath();
	}
}
