package com.letsdecode.problems.graph.cycledetection.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTree {
	HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
	boolean[] visited;

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		
		for (int[] edge : edges) {
			if (graph.containsKey(edge[0]) == false) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if (graph.containsKey(edge[1]) == false) {
				graph.put(edge[1], new HashSet<Integer>());
			}

			graph.get(edge[1]).add(edge[0]);
			graph.get(edge[0]).add(edge[1]);
		}

		Set<Map.Entry<Integer, HashSet<Integer>>> entrySet = graph.entrySet();
		LinkedList<Integer> l = new LinkedList<>();

		for (Map.Entry<Integer, HashSet<Integer>> entry : entrySet) {
			if (entry.getValue().size() == 1) {
				l.add(entry.getKey());
			}
		}

		while (graph.size() > 2) {
			ArrayList<Integer> newNodes = new ArrayList<>();
			while (l.isEmpty() == false) {
				int key = l.removeFirst();
				HashSet<Integer> set = graph.get(key);
				graph.remove(key);
				for (int i : set) {
					Set<Integer> removeFrom = graph.get(i);
					removeFrom.remove(key);
					if (removeFrom.size() == 1) {
						newNodes.add(i);
					}
				}
			}
			l.addAll(newNodes);
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (Integer i : graph.keySet()) {
			list.add(i);
		}

		return list;
	}
}
