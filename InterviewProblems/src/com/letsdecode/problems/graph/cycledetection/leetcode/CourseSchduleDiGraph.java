package com.letsdecode.problems.graph.cycledetection.leetcode;

import java.util.ArrayList;

public class CourseSchduleDiGraph {
	ArrayList<Integer> edges[];;
	boolean visited[];
	boolean stack[];

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		edges = new ArrayList[numCourses];
		visited = new boolean[numCourses];
		buidGraph(prerequisites);
		for (int i = 0; i < numCourses; i++) {
			stack = new boolean[numCourses];
			if (visited[i] == false && hasCycle(i)) {
				return false;
			}
		}
		return true;
	}

	private void buidGraph(int[][] prerequisites) {
		for (int[] e : prerequisites) {
			if (edges[e[1]] == null) {
				edges[e[1]] = new ArrayList<>();
			}
			edges[e[1]].add(e[0]);
		}
	}

	boolean hasCycle(int vertex) {
		visited[vertex] = true;
		stack[vertex] = true;
		ArrayList<Integer> ad = edges[vertex];
		if (ad != null) {
			for (int e : ad) {
				if (visited[e] == false) {
					boolean detected = hasCycle(e);
					if (detected) {
						return detected;
					}
				} else if (stack[e]) {
					return true;
				}
			}
		}
		stack[vertex] = false;
		return false;
	}

}
