package com.letsdecode.problems.graph.edgeweighted;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Set;

public class LazyPrim {
	PriorityQueue<Edge> pq = new PriorityQueue<>();
	LinkedList<Edge> mst = new LinkedList<>();
	HashSet<String> marked = new HashSet<>();

	public LazyPrim(EdgeWeightedGraph G) {
		Set<String> keys = G.edges.keySet();
		Iterator<String> i = keys.iterator();

		if (i.hasNext()) {
			String id = i.next();
			// Start with visiting first node
			visit(G, id);
			while (pq.isEmpty() == false) {
				Edge e = pq.poll();// Edge with the smallest weight
				Vertex v = e.either();
				Vertex w = e.other(v.id);
				if (marked.contains(v.id) && marked.contains(w.id)) {
					// Both vertices are already in tree, so skip this edge
					continue;
				}
				mst.add(e);
				if (marked.contains(v.id) == false)
					visit(G, v.id);
				if (marked.contains(v.id) == false)
					visit(G, v.id);
			}
		}
	}

	private void visit(EdgeWeightedGraph G, String id) {
		marked.add(id);
		Set<Edge> adj = G.edges.get(id);
		if (adj != null) {
			for (Edge e : adj) {
				// Get the other end of the edge and check if
				// that vertex is already in the tree
				Vertex w = e.other(id);
				if (marked.contains(w) == false) {
					pq.add(e);
				}
			}
		}
	}

	public LinkedList<Edge> mst() {
		return mst;
	}
}
