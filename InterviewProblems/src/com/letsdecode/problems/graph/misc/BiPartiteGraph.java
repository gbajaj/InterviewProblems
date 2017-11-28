package com.letsdecode.problems.graph.misc;

import java.util.HashSet;
import java.util.LinkedList;

public class BiPartiteGraph {
	public final HashSet<Vertex> vertices = new HashSet<>();

	class Vertex {
		String label;
		final public HashSet<Vertex> edges = new HashSet<>();
		private int distance = -1;

		@Override
		public int hashCode() {
			return label.hashCode();
		}

		public void reset() {
			distance = -1;
		}
		@Override
		public String toString() {
			return label;
		}
	}

	public void reset() {
		for (Vertex v : vertices) {
			//System.out.println("Vertex " + v +" edges " + v.edges);
			v.reset();
		}
	}

	public boolean BFS(Vertex v) {
		reset();
		LinkedList<Vertex> q = new LinkedList<>();
		// Start from source
		q.add(v);
		v.distance = 0;
		while (q.isEmpty() == false) {
			// remove the front node and check its neighbor
			Vertex cur = q.removeFirst();
			//System.out.println("removed " + cur.label);
			for (Vertex n : cur.edges) {
				//System.out.println("current neibhor" + n.label);
				if (n.distance == -1) {
					n.distance = cur.distance + 1;
					//System.out.println("added " + n.label);
					q.add(n);
				} else if (n.distance == cur.distance) {
					return false;
				}
			}

		}
		return true;
	}
}
