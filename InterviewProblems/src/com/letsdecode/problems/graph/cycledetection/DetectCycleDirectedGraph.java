package com.letsdecode.problems.graph.cycledetection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class DetectCycleDirectedGraph {
	public static class Vertex {
		int id;
		public Set<Vertex> adj = new HashSet<>();
		boolean visited;

		@Override
		public int hashCode() {

			return id;
		}
		
		public void addAdjacent(Vertex v) {
			adj.add(v);
		}
	}

	HashSet<Vertex> stackTrace = new HashSet<>();

	/*
	 * Time Complexity O(V+E).
	 */
	public boolean hasCycle(List<Vertex> vertices, boolean useV2) {
		for (int i = 0; i < vertices.size(); i++) {
			final Vertex vertex = vertices.get(i);
			if (useV2) {
				if (hasCycleV2(vertex)) {
					return true;
				}
			} else {
				if (hasCycle(vertex)) {
					return true;
				}
				
			}
		}
		return false;
	}

	private boolean hasCycle(Vertex vertex) {
		if (vertex.visited == false) {
			// Add to the stack in order to detect if vertex is already part of
			// the current
			// traversal
			stackTrace.add(vertex);
			// Mark as visited; If we ever went through through this node and
			// never detected a cycle then there is no need to visit this node
			// again
			vertex.visited = true;
			for (Vertex v : vertex.adj) {
				if (v.visited == false && hasCycle(v)) {
					// If never visited and detected a cycle
					return true;
				} else if (stackTrace.contains(v)) {
					// If this node is already part of the stack
					return true;
				}
			}
			// remove while going out
			stackTrace.remove(vertex);
		}
		return false;
	}

	private boolean hasCycleV2(Vertex vertex) {
		if (vertex == null) {
			return false;
		}
		if (stackTrace.contains(vertex)) {
			return true;
		}
		if (vertex.visited) {
			return false;
		}
		
		vertex.visited = true;
		
		stackTrace.add(vertex);
		boolean retVal = false;
		for (Vertex v : vertex.adj) {
			if (hasCycle(v)) {
				retVal = true;
			}
			
		}
		// remove while going out
		stackTrace.remove(vertex);
		return retVal;
	}
}
