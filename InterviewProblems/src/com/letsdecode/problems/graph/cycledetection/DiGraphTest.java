package com.letsdecode.problems.graph.cycledetection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;

import com.letsdecode.problems.graph.cycledetection.DiGraph.DiGraphVertex;

public class DiGraphTest {

	@Test
	public void testReversePost() {
		System.out.println("TEST: " + "testReversePost()");
		String[][] graphA = { { "a", "b" }, { "b", "c" }, { "c", "d" },
				{ "d", "b" } };

		DiGraph diGraph = new DiGraph();
		for (String a[] : graphA) {
			diGraph.addEdge(a[0], a[1]);
		}
		System.out.println(diGraph);

		Stack<DiGraphVertex> reversePost = diGraph.getReversePost();
		while (reversePost.isEmpty() == false) {

			DiGraphVertex d = reversePost.pop();
			System.out.print(d.id + " ");
		}
		System.out.println("");
		System.out.println("====================================");

	}

	@Test
	public void testTopologicalSort() {
		System.out.println("TEST: " + "testTopologicalSort()");
		String[][] graphA = { { "a", "b" }, { "b", "c" }, { "c", "p" },
				{ "d", "b" } };

		DiGraph diGraph = new DiGraph();
		for (String a[] : graphA) {
			diGraph.addEdge(a[0], a[1]);
		}
		System.out.println(diGraph);

		Stack<DiGraphVertex> reversePost = diGraph.topologicalSortDFS();
		while (reversePost.isEmpty() == false) {

			DiGraphVertex d = reversePost.pop();
			System.out.print(d.id + " ");
		}
		System.out.println("");
		System.out.println("====================================");
	}

	@Test
	public void test() {
		System.out.println("TEST: " + "test()");
		String[][] graphA = { { "a", "b" }, { "b", "c" }, { "c", "d" },
				{ "d", "b" }, { "l", "a" }, { "a", "l" } };

		DiGraph diGraph = new DiGraph();
		for (String a[] : graphA) {
			diGraph.addEdge(a[0], a[1]);
		}
		System.out.println(diGraph);

		System.out.println("After Reverse");
		ArrayList<HashSet<DiGraphVertex>> ccs = diGraph.CCs();
		for (HashSet<DiGraphVertex> cc : ccs) {
			System.out.println("CC : " + cc);
		}

		System.out.println("");
		System.out.println("====================================");
	}

}
