package com.letsdecode.problems.graph.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import com.letsdecode.problems.graph.build.DiGraph;
import com.letsdecode.problems.graph.build.Node;

public class SortedDictionary {
	/**
	 * Algorithm
	 * 1) Build a DiGraph using the sorted dictionary
	 * 2) Run topological sort on DiGraph
	 */
	private ArrayList<String> dic = new ArrayList<>();
	private DiGraph diGraph;

	public SortedDictionary(final ArrayList<String> dic, DiGraph diGraph) {
		this.dic = dic;
		this.diGraph = diGraph;
	}

	public void buildGraph() {
		if (diGraph.getnV() > 0)
			throw new IllegalStateException("Graph is already buit");

		for (int i = 0; i < dic.size() - 1; i++) {
			String w1 = dic.get(i);
			String w2 = dic.get(i + 1);
			for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				if (w1.charAt(j) != w2.charAt(j)) {
					diGraph.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
					// BREAK; we have to break as soon as first mismatched
					// character is found
					break;
				}
			}
		}
	}

	public Stack<Node> getOrder() {
		if (diGraph.getnV() <= 0)
			throw new IllegalStateException("Graph is not built yet");
		Stack<Node> stack = new Stack<>();
		HashSet<Node> visited = new HashSet<>();
		Set<Integer> set = diGraph.getKeySet();
		for (Integer e : set) {
			Node n = diGraph.getV(e);
			if (visited.contains(n) == false) {
				toplogicalSort(n, visited, stack);
			}
		}

		return stack;
	}
	/*
	 * Topological sort
	 */

	private void toplogicalSort(Node n, HashSet<Node> visited, Stack<Node> stack) {
		visited.add(n);
		Iterator<Node> it = n.getIterator();
		while (it.hasNext()) {
			Node nextNode = it.next();
			if (visited.contains(nextNode) == false) {
				toplogicalSort(nextNode, visited, stack);
			}
		}
		stack.push(n);
	}
}
