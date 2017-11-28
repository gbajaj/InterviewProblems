package com.letsdecode.problems.graph.cycledetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycleUnDirectedGraph {
	class Vertex {
		int id;
		public Set<Vertex> adj = new HashSet();
		boolean visited;
	}

	List<Vertex> vertices = new ArrayList<Vertex>();

	public boolean hasCycle(Vertex v) {
		if (v.visited) {
			return true;
		}
		v.visited = true;// Set Visited Flag
		Set<Vertex> set = v.adj;
		for (Vertex c : set) {
			return hasCycle(c);
		}
		v.visited = false;// Reset visited flag
		return false;
	}

	public void findUniqueCycles(Vertex v, int count[]) {
		if (v.visited) {
			count[0]++;
			return;
		}
		v.visited = true;// Set Visited Flag
		Set<Vertex> set = v.adj;
		for (Vertex c : set) {
			hasCycle(v);
		}
		v.visited = false;// Reset visited flag
	}

	public void findAllCyclesDFS() {
		// Reset all the vertices to be non visited
		int count[] = { 0 };
		for (Vertex v : vertices) {
			findUniqueCycles(v, count);
		}
		
	}
}
