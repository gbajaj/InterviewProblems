package com.letsdecode.problems.graph.edgeweighted;

import java.util.HashMap;
import java.util.Set;

public class EdgeWeightedGraph {
	HashMap<String, Set<Edge>> edges = new HashMap<>();

	public int E() {
		return edges.size();
	}

	public int V() {
		//no self loops and parrellel edges
		return edges.size() * 2;
	}

	public void addEdge(Edge e) {
		Vertex v = e.either();
		Vertex w = e.other(v.id);
		edges.get(v.id).add(e);
		edges.get(w.id).add(e);
	}

	public Set<Edge> adj(String id) {
		return edges.get(id);
	}
}
