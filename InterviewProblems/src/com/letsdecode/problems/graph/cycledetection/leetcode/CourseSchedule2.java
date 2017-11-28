package com.letsdecode.problems.graph.cycledetection.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule2 {
	ArrayList<Integer> edges[];;
	boolean visited[];
	boolean stack[];

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		edges = new ArrayList[numCourses];
		visited = new boolean[numCourses];
		buidGraph(prerequisites);
		for (int i = 0; i < numCourses; i++) {
			stack = new boolean[numCourses];
			if (visited[i] == false && hasCycle(i)) {
				return new int[0];
			}
		}

		return reversePostOrder(numCourses);

	}

	private int[] reversePostOrder(int numCourses) {
		// build the list to track order of finishing the traversal
		LinkedList<Integer> list = new LinkedList<>();
		visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			reversePostOrder(i, list);
		}
		int[] ret = new int[list.size()];
		int j = 0;
		for (Integer i : list) {
			ret[j] = i;
			j++;
		}
		return ret;
	}

	private void reversePostOrder(int vertex, LinkedList<Integer> list) {
		if (visited[vertex]) {
			return;
		}
		visited[vertex] = true;
		ArrayList<Integer> adj = edges[vertex];
		if (adj != null) {
			for (int e : adj) {
				reversePostOrder(e, list);
			}
		}
		// last node in the this direction
		list.addFirst(vertex);
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
