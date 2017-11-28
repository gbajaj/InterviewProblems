package com.letsdecode.problems.graph.cycledetection.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumHeightTreeTest {

	@Test
	public void test() {
		MinimumHeightTree minimumHeightTree = new MinimumHeightTree();
//		int vertices = 4;
//		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		int vertices = 6;
//		int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } };
		minimumHeightTree.findMinHeightTrees(4, edges);
	}
}
