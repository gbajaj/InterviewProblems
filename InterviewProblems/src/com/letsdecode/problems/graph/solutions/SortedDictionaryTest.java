package com.letsdecode.problems.graph.solutions;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import com.letsdecode.problems.graph.build.DiGraph;
import com.letsdecode.problems.graph.build.Node;

public class SortedDictionaryTest {

	@Test
	public void test() {
		DiGraph diGraph = new DiGraph();
		String words[] = { "baa", "abcd", "abca", "cab", "cad" };
		ArrayList arrayList = new ArrayList<>();

		arrayList.addAll(java.util.Arrays.asList(words));
		SortedDictionary sortedDictionary = new SortedDictionary(arrayList,
				diGraph);

		sortedDictionary.buildGraph();
		diGraph.printGraph();
		Stack<Node> nodes = sortedDictionary.getOrder();
		while (nodes.isEmpty() == false) {
			Node n = nodes.pop();
			System.out.print((char) ('a' + n.getLabel()) + " ");
		}
	}

}
