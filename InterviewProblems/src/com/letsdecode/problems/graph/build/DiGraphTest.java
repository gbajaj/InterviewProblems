package com.letsdecode.problems.graph.build;

import org.junit.Test;

public class DiGraphTest {

	@Test
	public void test() {
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };

		DiGraph diGraph = new DiGraph();
		for (int[] a : graph) {
			int start = a[0];
			for (int i = 1; i < a.length; i++) {
				diGraph.addEdge(start, a[i]);
			}
		}
		int nV = diGraph.getnV();
		int nE = diGraph.getnE();
		System.out.println("Vertices " + nV + " Edges " + nE);

	}
}
