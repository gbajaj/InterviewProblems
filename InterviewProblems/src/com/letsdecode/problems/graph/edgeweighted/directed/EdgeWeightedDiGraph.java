package com.letsdecode.problems.graph.edgeweighted.directed;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class EdgeWeightedDiGraph {
	HashMap<String, Vertex> vertices = new HashMap<>();;
	HashMap<String, Set<DirectedEdge>> edges = new HashMap<>();

	public int E() {
		return edges.size();
	}

	public int V() {
		// no self loops and parrellel edges
		return edges.keySet().size();
	}

	public void addEdge(DirectedEdge e) {
		String v = e.from();
		Set<DirectedEdge> adj = edges.get(v);
		if (adj == null) {
			adj = new HashSet<>();
			edges.put(v, adj);
		}
		adj.add(e);
	}

	public Set<DirectedEdge> adj(String id) {
		return edges.get(id);
	}

	public Set<String> vertices() {
		return edges.keySet();
	}

	public Collection<DirectedEdge> edges() {
		HashSet<DirectedEdge> set = new HashSet<>();
		for (Set<DirectedEdge> s : edges.values()) {
			set.addAll(s);
		}
		return set;
	}

	public Vertex getVertex(String vId) {
		return vertices.get(vId);
	}

	public Vertex addVertex(Vertex vertex) {
		Vertex v = vertices.get(vertex.id);
		if (v == null) {
			v = vertices.put(vertex.id, vertex);
		}
		return v;
	}
}
